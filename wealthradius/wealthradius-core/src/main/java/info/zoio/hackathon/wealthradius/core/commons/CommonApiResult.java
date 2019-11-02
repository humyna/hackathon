package info.zoio.hackathon.wealthradius.core.commons;

import java.io.Serializable;


/**
 *
 * 类名: CommonResult <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
public class CommonApiResult<T> implements Serializable {
    /**
	 * serialVersionUID:TODO（用一句话描述这个变量表示什么）
	 *
	*/
	private static final long serialVersionUID = 6413270562869445528L;
	
    /**
     * 状态码
     */
    public String result; // 结果
    /**
     * 错误代码
     */
    public String errorCode; // 错误码
    /**
     * 错误描述
     */
    public String msg; // 错误信息


    
    /**
     * 实际返回数据对象
     */
    private T data;

	public void setResult(ApiResultCode resultCode) {
        this.result = resultCode.getResult();
        this.errorCode = resultCode.getResultCode();
        this.msg = resultCode.getResultDesc();
    }
	
	public void setResult(CommonApiResult<?> commonApiResult) {
	        this.result = commonApiResult.getResult();
	        this.errorCode = commonApiResult.getErrorCode();
	        this.msg = commonApiResult.getMsg();
	 }

	
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	 /**
     * 静态工厂方法，创建成功返回结果
     * @param <T> 实际返回数据对象类型
     * @return CommonApiResult
     */
    public static <T> CommonApiResult<T> createSuccessResult() {
    	CommonApiResult<T> commonApiResult = new CommonApiResult<>();
    	commonApiResult.setResult(ApiResultCode.SUCCESS);
        return commonApiResult;
    }

    /**
     * 静态工厂方法，创建指定错误码的返回结果
     * @param apiResultCode 错误码
     * @param <T> 实际返回数据对象类型
     * @return CommonApiResult
     */
    public static <T> CommonApiResult<T> createErrResult(ApiResultCode apiResultCode) {
    	CommonApiResult<T> commonApiResult = new CommonApiResult<>();
    	commonApiResult.setResult(apiResultCode);
        return commonApiResult;
    }
    /**
     * 静态工厂方法，根据传入数据对象，创建成功返回结果
     * @param data 实际数据对象
     * @param <T> 实际返回数据对象类型
     * @return CommonApiResult
     */
    public static <T> CommonApiResult<T> createSuccessDataResult(T data) {
    	CommonApiResult<T> commonApiResult = createSuccessResult();
    	commonApiResult.setData(data);
        return commonApiResult;
    }
    
}

	