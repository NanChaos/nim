package cn.nanchaos.nim.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Default Description
 * dubbo统一返回对象
 *
 * @author: nanchaos
 * @time: 2022/1/12
 */
@Getter
@Setter
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -7905985643672828588L;

    /**
     * 调用是否成功
     */
    private Boolean success;

    /**
     * 调用结果集
     */
    private T result;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误描述
     */
    private String errorMsg;

    /**
     * 默认构造方法
     */
    public Result() {
    }

    /**
     * 直接构造成功的返回
     * @param result 返回结果
     */
    public Result(T result) {

        this.success = true;
        this.result = result;
    }

    /**
     * 直接构造失败的返回
     * @param errorCode     错误码
     * @param errorMsg      错误描述
     */
    public Result(String errorCode, String errorMsg) {

        this.success = false;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
