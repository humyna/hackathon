package info.zoio.hackathon.wealthradius.core.service.bean;

/**
 *
 * 类名: UserInfoBean <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
public class UserInfoBean {
	 /**
     * 用户id
     */
    private Long userId;

    /**
     * 手机号
     */
    private String mobileNo;

    /**
     * 昵称
     */
    private String nickName;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "UserInfoBean [userId=" + userId + ", mobileNo=" + mobileNo + ", nickName="
				+ nickName + "]";
	}
	
	
}

	