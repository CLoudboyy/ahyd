package cn.edu.guet.util;

import cn.edu.guet.common.ResponseData;
import cn.edu.guet.dao.impl.BaseDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @Author liwei
 * @Date 2023/6/11 15:44
 * @Version 1.0
 */
public class TransactionHandler implements InvocationHandler {
    public static Logger logger = LoggerFactory.getLogger(TransactionHandler.class);
    // 目标对象
    private Object targetObject;

    /**
     * 根据目标对象创建代理对象
     *
     * @param targetObject
     * @return
     */
    public Object createProxyObject(Object targetObject) {
        this.targetObject = targetObject;
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        Connection conn = null;
        try {
            conn = DBConnection.getConn();
            logger.info("动态代理类中的conn哈希值：" + conn.hashCode());
            // 方法名称的开头
            // 增：create、save、new
            // 删：delete
            // 改：update
            // 方法名字：2023-06-11 16:44:36.866 方法名称：searchBill
            // 2023-06-11 16:45:12.465 方法名称：createBillAndAnalyse
            logger.info("方法名称：{}", method.getName());
            Object retValue = null;
            if (method.getName().startsWith("create") || method.getName().startsWith("save")
                    || method.getName().startsWith("new")
                    || method.getName().startsWith("delete")
                    || method.getName().startsWith("update")) {
                // 开启事务
                conn.setAutoCommit(false);
                // 调用目标方法：调用PlanDesignServiceImpl的createBillAndAnalyse方法
                retValue = method.invoke(targetObject, args);
                // 提交事务
                conn.commit();
            } else {
                // 不开事务，直接调用目标方法
                retValue = method.invoke(targetObject, args);
            }
            return retValue;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            try {
                conn.rollback();
                System.out.println("事务进行了回滚操作");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return ResponseData.fail("保存失败！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
