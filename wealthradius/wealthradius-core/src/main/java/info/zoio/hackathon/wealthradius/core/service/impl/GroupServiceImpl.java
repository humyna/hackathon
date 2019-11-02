package info.zoio.hackathon.wealthradius.core.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.zoio.hackathon.wealthradius.core.commons.GroupStateEnum;
import info.zoio.hackathon.wealthradius.core.mappers.GroupInfoMapper;
import info.zoio.hackathon.wealthradius.core.mappers.OrderInfoMapper;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.GroupInfo;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.OrderInfo;
import info.zoio.hackathon.wealthradius.core.service.GroupService;
import info.zoio.hackathon.wealthradius.core.service.OrderService;
import info.zoio.hackathon.wealthradius.core.service.bean.GroupInfoBean;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: GroupServiceImpl <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 1:05:38 PM
*/
@Slf4j
@Component
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupInfoMapper groupInfoMapper;
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	@Autowired
	private OrderService orderService;
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.GroupService#getGroupInfoBeanByState(java.lang.String)
	 * @param state
	 * @return
	*/
	@Override
	public List<GroupInfoBean> getGroupInfoBeanByState(String state) {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setGroupState(state);
		List<GroupInfo> groupInfos = groupInfoMapper.select(groupInfo);
		List<GroupInfoBean> retList = new ArrayList<GroupInfoBean>();
		if(groupInfos!=null && groupInfos.size() >0){
			for (GroupInfo groupInfo2 : groupInfos) {
				GroupInfoBean groupInfoBean =new GroupInfoBean();
				groupInfoBean.setGroupId(groupInfo2.getGroupId());
				groupInfoBean.setProductId(groupInfo2.getProductId());
				groupInfoBean.setGroupNum(groupInfo2.getGroupNum());
				groupInfoBean.setGroupState(groupInfo2.getGroupState());
				groupInfoBean.setSponsorUserId(groupInfo2.getSponsorUserId());
				retList.add(groupInfoBean);
			}
			return retList;
		}
		
		return null;
	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.GroupService#getGroupInfoBeanByGroupId(java.lang.Long)
	 * @param groupId
	 * @return
	*/
	@Override
	public GroupInfoBean getGroupInfoBeanByGroupId(Long groupId) {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setGroupId(groupId);
		groupInfo = groupInfoMapper.selectOne(groupInfo);
		
		if(groupInfo != null){
			GroupInfoBean groupInfoBean =new GroupInfoBean();
			groupInfoBean.setGroupId(groupInfo.getGroupId());
			groupInfoBean.setProductId(groupInfo.getProductId());
			groupInfoBean.setGroupNum(groupInfo.getGroupNum());
			groupInfoBean.setGroupState(groupInfo.getGroupState());
			groupInfoBean.setSponsorUserId(groupInfo.getSponsorUserId());
			return groupInfoBean;
		}
		
		return null;
	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.GroupService#creatGroup(java.lang.Long, java.lang.Long, java.math.BigDecimal, java.lang.Integer)
	 * @param userId
	 * @param productId
	 * @param investAmount
	 * @param groupSum
	 * @return
	*/
	@Override
	public boolean creatGroup(Long userId, Long productId, BigDecimal investAmount,Integer buyUnit,Integer groupSum) {
		//开团逻辑：生成拼团记录；同时记录一条订单
		
		if(userId == null || productId == null || investAmount == null || investAmount.compareTo(BigDecimal.ZERO) <=0 || groupSum <= 1){
			log.error("开团失败，参数不能为空");
			return false;
		}
		
		GroupInfo groupInfo = initGroupInfo(userId, productId, groupSum);
		groupInfoMapper.insert(groupInfo);
		OrderInfo orderInfo  = initOrderInfo(userId, productId, investAmount, groupInfo.getGroupId(), buyUnit);
		orderInfoMapper.insert(orderInfo);
				
		return true;
			
	}
	
	private GroupInfo initGroupInfo(Long userId,Long productId,Integer groupSum){
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setProductId(productId);
		groupInfo.setSponsorUserId(userId);
		groupInfo.setGroupState(GroupStateEnum.GROUPING.getStateValue());
		groupInfo.setPayDate(new Date());
		groupInfo.setCreateDate(new Date());
		groupInfo.setGroupNum(groupSum);
		groupInfo.setComments("开团");
		return groupInfo;
	}
	
	private OrderInfo initOrderInfo(Long userId,Long productId,BigDecimal investAmount,Long groupId,Integer buyUnit){
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setProductId(productId);
		orderInfo.setGroupId(groupId);
		orderInfo.setUserId(userId);
		orderInfo.setPayAmount(investAmount);
		orderInfo.setBuyType("1");//拼团方式
		orderInfo.setBuyUnit(buyUnit);
		orderInfo.setCreateDate(new Date());
		orderInfo.setPayState("1");//演示默认支付成功
		orderInfo.setOrderState("1");//演示默认计息中
		orderInfo.setStartDate(new Date());
		orderInfo.setEndDate(new Date());//TODO 需要处理
		orderInfo.setComments("拼团下单");
		return orderInfo;
	}
	
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.GroupService#joinGroup(java.lang.Long, java.lang.Long, java.lang.Long, java.math.BigDecimal)
	 * @param userId
	 * @param groupId
	 * @param productId
	 * @param investAmount
	 * @return
	*/
	@Override
	public boolean joinGroup(Long userId, Long groupId, Long productId, BigDecimal investAmount,Integer buyUnit) {
		//参团逻辑：校验是否有这个团以及状态是否已满；校验这个用户是否已经参团了；如果都没有，生成订单记录；更新拼团状态
		
		if(userId == null || groupId == null || productId == null || investAmount == null || investAmount.compareTo(BigDecimal.ZERO) <=0 || buyUnit <=0){
			log.error("参团失败，参数不能为空[userId={},groupId={},productId={},investAmount={},buyUnit={}]",userId,groupId,productId,investAmount,buyUnit);
			return false;
		}
		
		GroupInfo groupInfo =  new GroupInfo();
		groupInfo.setGroupId(groupId);
		groupInfo = groupInfoMapper.selectOne(groupInfo);
		if(groupInfo == null || !GroupStateEnum.GROUPING.getStateValue().equals(groupInfo.getGroupState())){
			log.error("参团失败，该拼团不存在或状态不正确[userId={},groupId={},productId={},investAmount={},buyUnit={}]",userId,groupId,productId,investAmount,buyUnit);
			return false;
		}
		
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setUserId(userId);
		orderInfo.setGroupId(productId);
		orderInfo = orderInfoMapper.selectOne(orderInfo);
		if(orderInfo !=null && !"0".equals(orderInfo.getOrderState())){//演示不检查未支付的单子
			log.error("参团失败，用户已参与过该团[userId={},groupId={},productId={},investAmount={},buyUnit={}]",userId,groupId,productId,investAmount,buyUnit);
			return false;
		}
		
		orderInfo = initOrderInfo(userId, productId, investAmount, groupId, buyUnit);
		orderInfoMapper.insert(orderInfo);
		
		//根据拼团查询该团总数以及总订单数，如果相等，则更新拼团状态为拼团成功
		Integer orderCount = orderService.countOrderByGroupId(groupId);
		if(orderCount == groupInfo.getGroupNum()){
			log.info("参团成功，更新拼团状态为已满[userId={},groupId={},productId={},investAmount={},buyUnit={}]",userId,groupId,productId,investAmount,buyUnit);
			groupInfo.setGroupState(GroupStateEnum.GROUP_SUCC.getStateValue());
			groupInfo.setComments("拼团成功");
			groupInfoMapper.updateByPrimaryKey(groupInfo);
		}
		return true;
	}
	
}

	