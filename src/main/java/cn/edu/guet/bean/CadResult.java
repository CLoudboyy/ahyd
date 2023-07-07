package cn.edu.guet.bean;


/**
 * 查询CAD分析结果封装
 * @Author liwei
 * @Date 2023/5/4 17:00
 * @Version 1.0
 */
public class CadResult {

    private String code;
    private String message;
    private CadData data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CadData getData() {
        return data;
    }

    public void setData(CadData data) {
        this.data = data;
    }
}
