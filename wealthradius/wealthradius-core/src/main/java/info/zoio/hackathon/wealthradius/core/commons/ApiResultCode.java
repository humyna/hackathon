package info.zoio.hackathon.wealthradius.core.commons;

public enum ApiResultCode {
    
	SUCCESS("0000", "成功", ApiResultConstants.SUCCESS_STATUS),
	LOCAL_EXCEPTION("0001", "系统异常", ApiResultConstants.EXCEPTION_STATUS),
	PARAM_IS_NULL("0002", "参数不能为空", ApiResultConstants.EXCEPTION_STATUS),
	USER_MOBILENO_CANT_NULL("1000", "手机号不能为空", ApiResultConstants.SUCCESS_STATUS),
	USER_ERROR_MOBILENO("1001", "手机号格式不正确", ApiResultConstants.SUCCESS_STATUS),
	USER_REGISTED("1002", "该用户已注册", ApiResultConstants.SUCCESS_STATUS),
	USER_FACEINFO_CANT_NULL("1003", "人脸信息不能为空", ApiResultConstants.SUCCESS_STATUS),
	USER_NOT_EXIST("1004", "登录失败-用户信息不存在", ApiResultConstants.SUCCESS_STATUS),
	
	PRODUCT_NOT_EXIST("2000", "没有产品信息", ApiResultConstants.SUCCESS_STATUS),

	GROUP_NOT_LEGAL("3000", "没有开团信息", ApiResultConstants.SUCCESS_STATUS),
	GROUP_FAILURE("3001", "开团失败", ApiResultConstants.SUCCESS_STATUS),
	ORDER_NOT_LEGAL("4000", "没有订单信息", ApiResultConstants.SUCCESS_STATUS),
	
	;
    /**
     * 结果返回码
     */
    private String resultCode;
    /**
     * 结果返回消息
     */
    private String resultDesc;
    /**
     * 成功状态，详见{@link ApiResultConstants}
     */
    private String result;

    ApiResultCode(String resultCode, String resultDesc, String result) {
        this.resultCode = resultCode;
        this.resultDesc = resultDesc;
        this.result = result;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }


	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
