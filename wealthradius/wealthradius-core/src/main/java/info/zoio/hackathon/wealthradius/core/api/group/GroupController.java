package info.zoio.hackathon.wealthradius.core.api.group;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.zoio.hackathon.wealthradius.core.commons.ApiResultCode;
import info.zoio.hackathon.wealthradius.core.commons.CommonApiResult;
import info.zoio.hackathon.wealthradius.core.commons.GroupStateEnum;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.GroupInfo;
import info.zoio.hackathon.wealthradius.core.service.GroupService;
import info.zoio.hackathon.wealthradius.core.service.OrderService;
import info.zoio.hackathon.wealthradius.core.service.bean.GroupInfoBean;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: GroupController <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
@Slf4j
@RestController
public class GroupController {
	@Autowired
	private GroupService groupService;
	@Autowired
	private OrderService orderService;
	//TODO 开团/拼团-支付触发
	//开团： 发起人 产品id 拼团ing 
	@RequestMapping(method = {RequestMethod.POST}, value = "/api/group/saveGroupInfo", produces = "application/json; charset=utf-8")
	public CommonApiResult<Boolean> saveGroupInfo(Long userId,Long groupId,Long productId,BigDecimal investAmount,Integer groupSum,Integer buyUnit){
		//groupId为空则为开团，不为空则为参团
		if(userId == null || productId == null){
			return CommonApiResult.createErrResult(ApiResultCode.PARAM_IS_NULL);
		}
		//如果groupId为空或者查询不到开团信息，则新开团。否则参团
		GroupInfoBean groupInfoBean = new GroupInfoBean();
		boolean retFlag= false;
		if(groupId == null || (groupInfoBean = groupService.getGroupInfoBeanByGroupId(groupId)) == null){//进行开团，没有限制一个用户最多开团数
			log.info("用户userId={}开始开团productId={}",userId,productId);
			retFlag = groupService.creatGroup(userId, productId, investAmount, buyUnit, groupSum);
		}else{
			log.info("用户userId={}开始参团productId={},groupId={}",userId,productId,groupId);
			retFlag = groupService.joinGroup(userId, groupId, productId, investAmount, buyUnit);
		}
		 
		if(retFlag){
			return CommonApiResult.createSuccessDataResult(retFlag);
		}else{
			return CommonApiResult.createErrResult(ApiResultCode.GROUP_FAILURE);
		}
	 }
	
	
	
	
	//TODO 根据产品Id查询成功拼团的人数
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/api/group/getSuccGroupCountByProductId", produces = "application/json; charset=utf-8")
	public CommonApiResult<Integer> getSuccGroupCountByProductId(Long productId){//包括单独购买与拼团的
		log.info("查询成功购买productId={}的人数开始",productId);
		if(productId == null){
    		return CommonApiResult.createErrResult(ApiResultCode.PARAM_IS_NULL);
    	}
		Integer count = orderService.countOrderByGroupId(productId);
		log.info("查询成功购买productId={}的人数完成，共计{}人购买",productId,count);
		return CommonApiResult.createSuccessDataResult(count);
	 }
	 
	//TODO 根据状态查询拼团列表
	@RequestMapping(method = {RequestMethod.POST,RequestMethod.GET}, value = "/api/group/getGroupListByState", produces = "application/json; charset=utf-8")
	public CommonApiResult<List<GroupInfoBean>> getGroupListByState(String state){
//		if(!StringUtils.isEmpty(state) && !GroupStateEnum.isLegal(state)){
//    		return CommonApiResult.createErrResult(ApiResultCode.GROUP_STATE_NOT_LEGAL);
//		}
		
		List<GroupInfoBean> groups= groupService.getGroupInfoBeanByState(state);
		if(groups !=null && groups.size() > 0){
			for (GroupInfoBean groupInfoBean : groups) {
				//TODO 完善剩余人数（总数-已经参团人数groupid在订单表查询成功的记录数）
				Integer count = orderService.countOrderByGroupId(groupInfoBean.getGroupId());
				log.info("成功参团groupId={}的人数为{}",groupInfoBean.getGroupId(),count);
				groupInfoBean.setLeftNum(groupInfoBean.getGroupNum()-count);
			}
			
    		log.info("共有{}条开团信息",groups.size());
    		return CommonApiResult.createSuccessDataResult(groups);
		}else{
			log.info("没有开团信息");
			return CommonApiResult.createErrResult(ApiResultCode.GROUP_NOT_LEGAL);
		}
	 }
}

	