package info.zoio.hackathon.wealthradius.core.service;

import info.zoio.hackathon.wealthradius.core.service.bean.UserInfoBean;

/**
 *
 * 类名: UserService <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
public interface UserService {
	//根据手机号查询用户信息
	UserInfoBean getUserInfoByMobileNo(String mobileNo);
	//用户注册
	Long userRegister(String mobileNo,String faceSignInfo,String nickName);
	
	//根据人脸信息查询用户信息
	UserInfoBean getUserInfoByFaceSignInfo(String faceSignInfo);
	
	UserInfoBean getUserInfoByUserId(Long userId);
	
}

	