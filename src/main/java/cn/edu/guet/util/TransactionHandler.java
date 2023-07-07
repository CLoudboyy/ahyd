package cn.edu.guet.util;

import cn.edu.guet.common.ResponseData;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
        SqlSession sqlSession = null;
        try {
            sqlSession = DBUtil.getSqlSession();
            // 方法名称的开头
            // 增：create、save、new
            // 删：delete
            // 改：update
            logger.info("方法名称：{}", method.getName());
            Object retValue = null;
            if (method.getName().startsWith("create") || method.getName().startsWith("save")
                    || method.getName().startsWith("new")
                    || method.getName().startsWith("delete")
                    || method.getName().startsWith("update")) {
                retValue = method.invoke(targetObject, args);
                // 提交事务
                sqlSession.commit();
            } else {
                // 不开事务，直接调用目标方法
                retValue = method.invoke(targetObject, args);
            }
            return retValue;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            sqlSession.rollback();
            return ResponseData.fail("保存失败！");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
        return null;
    }
}
