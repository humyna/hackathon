package info.zoio.hackathon.wealthradius.core.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import info.zoio.hackathon.wealthradius.core.mappers.UserInfoMapper;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.UserInfo;
import info.zoio.hackathon.wealthradius.core.service.UserService;
import info.zoio.hackathon.wealthradius.core.service.bean.UserInfoBean;

/**
 *
 * 类名: UserServiceImpl <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserInfoMapper userInfoMapper;
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.UserService#getUserInfoByMobileNo(java.lang.String)
	 * @param mobileNo
	 * @return
	*/
	@Override
	public UserInfoBean getUserInfoByMobileNo(String mobileNo) {
		UserInfo userInfo = new UserInfo();
		userInfo.setMobileNo(mobileNo);
		userInfo = userInfoMapper.selectOne(userInfo);
		
		if(userInfo != null){
			UserInfoBean userInfoBean = new UserInfoBean();
			userInfoBean.setUserId(userInfo.getUserId());
			userInfoBean.setMobileNo(userInfo.getMobileNo());
			userInfoBean.setNickName(userInfo.getNickName());
			return userInfoBean;
		}
		return null;
	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.UserService#userRegister(java.lang.String, java.lang.String, java.lang.String)
	 * @param mobileNo
	 * @param faceSignInfo
	 * @param nickName
	 * @return
	*/
	@Override
	public Long userRegister(String mobileNo, String faceSignInfo, String nickName) {
		UserInfo userInfo = new UserInfo();
		userInfo.setMobileNo(mobileNo);
		
		if(StringUtils.isEmpty(nickName)){
			userInfo.setNickName("N"+mobileNo);
		}else{
			userInfo.setNickName(nickName);
		}
		
		userInfo.setFaceSignInfo(faceSignInfo);
		userInfo.setCreateDate(new Date());
		if(!StringUtils.isEmpty(faceSignInfo)){
			UserInfoBean userInfoBean = getUserInfoByMobileNo(mobileNo);
			if(userInfoBean != null){
				userInfo.setUserId(userInfoBean.getUserId());
				 userInfoMapper.updateByPrimaryKey(userInfo);
				 return userInfo.getUserId();
			}
		}
		
		userInfoMapper.insert(userInfo);
		return 	userInfo.getUserId();
	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.UserService#getUserInfoByFaceSignInfo(java.lang.String)
	 * @param faceSignInfo
	 * @return
	*/
	@Override
	public UserInfoBean getUserInfoByFaceSignInfo(String faceSignInfo) {
		UserInfo userInfo = new UserInfo();
		userInfo.setFaceSignInfo(faceSignInfo);
		userInfo = userInfoMapper.selectOne(userInfo);
		
		if(userInfo != null){
			UserInfoBean userInfoBean = new UserInfoBean();
			userInfoBean.setUserId(userInfo.getUserId());
			userInfoBean.setMobileNo(userInfo.getMobileNo());
			userInfoBean.setNickName(userInfo.getNickName());
			return userInfoBean;
		}
		return null;
			
	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.UserService#getUserInfoByUserId(java.lang.String)
	 * @param userId
	 * @return
	*/
	@Override
	public UserInfoBean getUserInfoByUserId(Long userId) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(userId);
		userInfo = userInfoMapper.selectOne(userInfo);
		
		if(userInfo != null){
			UserInfoBean userInfoBean = new UserInfoBean();
			userInfoBean.setUserId(userInfo.getUserId());
			userInfoBean.setMobileNo(userInfo.getMobileNo());
			userInfoBean.setNickName(userInfo.getNickName());
			return userInfoBean;
		}
		return null;
			
	}
	

}

	