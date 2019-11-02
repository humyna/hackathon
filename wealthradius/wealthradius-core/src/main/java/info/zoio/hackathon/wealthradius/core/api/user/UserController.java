package info.zoio.hackathon.wealthradius.core.api.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.zoio.hackathon.wealthradius.core.commons.ApiResultCode;
import info.zoio.hackathon.wealthradius.core.commons.CommonApiResult;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.UserInfo;
import info.zoio.hackathon.wealthradius.core.service.UserService;
import info.zoio.hackathon.wealthradius.core.service.bean.UserInfoBean;
import info.zoio.hackathon.wealthradius.core.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: UserController <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
@Slf4j
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	//手机注册
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/user/userRegisterByMobileNo", produces = "application/json; charset=utf-8")
	public CommonApiResult<Long> userRegisterByMobileNo(String mobileNo,String smsCheckCode,String password,String nickName){
		log.info("用户mobileNo={}开始手机注册",mobileNo);
    	//校验手机是否已经注册，如果已经注册
    	if(StringUtils.isEmpty(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_MOBILENO_CANT_NULL);
    	}
    	
    	if(!UserUtils.isMobile(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_ERROR_MOBILENO);
    	}
    	if(userService.getUserInfoByMobileNo(mobileNo) != null){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_REGISTED);
    	}
    	
    	//注册 
    	Long userId = userService.userRegister(mobileNo, null, nickName);
    	log.info("用户mobileNo={}手机注册完成",mobileNo);
		return CommonApiResult.createSuccessDataResult(userId);
	}
	//刷脸认证
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/user/userRegisterByFaceInfo", produces = "application/json; charset=utf-8")
	public CommonApiResult<Long> userRegisterByFaceInfo(String mobileNo,String faceSignInfo,String nickName){
    	log.info("用户mobileNo={}开始刷脸验证",mobileNo);
    	if(StringUtils.isEmpty(faceSignInfo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_FACEINFO_CANT_NULL);
    	}
    	
    	if(StringUtils.isEmpty(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_MOBILENO_CANT_NULL);
    	}
    	
    	if(!UserUtils.isMobile(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_ERROR_MOBILENO);
    	}
    	
    	Long userId = userService.userRegister(mobileNo, faceSignInfo, nickName);
    	log.info("用户mobileNo={}刷脸验证完成",mobileNo);
    	return CommonApiResult.createSuccessDataResult(userId);
	}
	//手机登录
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/user/userLoginByMobileNo", produces = "application/json; charset=utf-8")
	public CommonApiResult<Long> userLoginByMobileNo(String mobileNo,String smsCheckCode,String password){
    	log.info("用户mobileNo={}开始手机登录",mobileNo);
    	//校验手机是否已经注册，如果已经注册
    	if(StringUtils.isEmpty(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_MOBILENO_CANT_NULL);
    	}
    	
    	if(!UserUtils.isMobile(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_ERROR_MOBILENO);
    	}
    	UserInfoBean userInfoBean = userService.getUserInfoByMobileNo(mobileNo);
    	if(userInfoBean != null){
    		log.info("用户mobileNo={}手机登录完成，user_id={}",mobileNo,userInfoBean.getUserId());
    		return CommonApiResult.createSuccessDataResult(userInfoBean.getUserId());
    	}else{
    		log.info("用户mobileNo={}手机登录完成",mobileNo);
    		return CommonApiResult.createErrResult(ApiResultCode.USER_NOT_EXIST);
    	}
    	    	
	}
	//刷脸登录
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/user/userLoginByFaceInfo", produces = "application/json; charset=utf-8")
	public CommonApiResult<Long> userLoginByFaceInfo(String faceSignInfo){
    	if(StringUtils.isEmpty(faceSignInfo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_FACEINFO_CANT_NULL);
    	}
    	
    	// 校验人脸信息是否存在
    	UserInfoBean userInfoBean = userService.getUserInfoByFaceSignInfo(faceSignInfo);
		
    	if(userInfoBean != null){
    		return CommonApiResult.createSuccessDataResult(userInfoBean.getUserId());
    	}else{
    		return CommonApiResult.createErrResult(ApiResultCode.USER_NOT_EXIST);
    	}
	}
	
	//根据uswerId查询用户信息 
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/user/getUserInfoByUserId", produces = "application/json; charset=utf-8")
	public CommonApiResult<UserInfoBean> getUserInfoByUserId(Long userId){
    	if(userId == null){
    		return CommonApiResult.createErrResult(ApiResultCode.PARAM_IS_NULL);
    	}
    	UserInfoBean userInfoBean = userService.getUserInfoByUserId(userId);
    	if(userInfoBean==null){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_NOT_EXIST);
    	}
    	return CommonApiResult.createSuccessDataResult(userInfoBean);
    }
    
    //根据mobileNo查询用户信息 
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/user/getUserInfoByMobileNo", produces = "application/json; charset=utf-8")
	public CommonApiResult<UserInfoBean> getUserInfoByMobileNo(String mobileNo){
    	if(StringUtils.isEmpty(mobileNo)){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_MOBILENO_CANT_NULL);
    	}
    	
    	UserInfoBean userInfoBean = userService.getUserInfoByMobileNo(mobileNo);
    	if(userInfoBean==null){
    		return CommonApiResult.createErrResult(ApiResultCode.USER_NOT_EXIST);
    	}
    	return CommonApiResult.createSuccessDataResult(userInfoBean);
    }
}

	