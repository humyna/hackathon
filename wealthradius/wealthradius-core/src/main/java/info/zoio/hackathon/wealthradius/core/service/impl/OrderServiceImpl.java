/*
* 宜人贷
*OrderServiceImpl.java
*
* Copyright (c) 2019 宜人恒业科技发展(北京)有限公司
* All rights reserved.
* --------------------------
* Oct 25, 2019 Created
*/
package info.zoio.hackathon.wealthradius.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.zoio.hackathon.wealthradius.core.mappers.OrderInfoMapper;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.OrderInfo;
import info.zoio.hackathon.wealthradius.core.service.OrderService;
import info.zoio.hackathon.wealthradius.core.service.bean.OrderInfoBean;
import io.micrometer.core.lang.NonNull;

/**
 *
 * 类名: OrderServiceImpl <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 1:53:17 PM
*/
@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderInfoMapper orderInfoMapper;
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.OrderService#countOrderByGroupId(java.lang.Long)
	 * @param groupId
	 * @return
	*/
	@Override
	public Integer countOrderByGroupId(Long groupId) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setGroupId(groupId);
		orderInfo.setPayState("1");//支付成功
//		Integer count = orderInfoMapper.selectCount(orderInfo);
		return orderInfoMapper.selectCount(orderInfo);

	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.OrderService#getOrderInfoBeanListByUserId(java.lang.Long)
	 * @param userId
	 * @return
	*/
	@Override
	public List<OrderInfoBean> getOrderInfoBeanListByUserId(Long userId) {
		// TODO Auto-generated method stub
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setUserId(userId);
		List<OrderInfo> orderInfos = orderInfoMapper.select(orderInfo);
		List<OrderInfoBean> retList = new ArrayList<OrderInfoBean>();
		if(orderInfos != null && orderInfos.size() >0){
			for (OrderInfo orderInfo2 : orderInfos) {
				OrderInfoBean orderInfoBean = new OrderInfoBean();
				orderInfoBean.setUserId(userId);
				orderInfoBean.setProductId(orderInfo2.getProductId());
				orderInfoBean.setGroupId(orderInfo2.getGroupId());
				orderInfoBean.setBuyType(orderInfo2.getBuyType());
				orderInfoBean.setOrderId(orderInfo2.getOrderId());
				orderInfoBean.setBuyUnit(orderInfo2.getBuyUnit());
				orderInfoBean.setPayAmount(orderInfo2.getPayAmount());
				orderInfoBean.setPayState(orderInfo2.getPayState());
				orderInfoBean.setOrderState(orderInfo2.getOrderState());
				orderInfoBean.setStartDate(orderInfo2.getStartDate());
				orderInfoBean.setEndDate(orderInfo2.getEndDate());
				orderInfoBean.setActualEarnings(orderInfo2.getActualEarnings());
				orderInfoBean.setRewardIncome(orderInfo2.getRewardIncome());
				orderInfoBean.setExitTime(orderInfo2.getExitTime());
				orderInfoBean.setEstimatedEarnings(orderInfo2.getEstimatedEarnings());
				retList.add(orderInfoBean);
			}
			
			return retList;
		}
		
		
		return null;
			
	}
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.OrderService#countOrderByProductId(java.lang.Long)
	 * @param prodcutId
	 * @return
	*/
	@Override
	public Integer countOrderByProductId(Long prodcutId) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setProductId(prodcutId);
		orderInfo.setPayState("1");//支付成功
		return orderInfoMapper.selectCount(orderInfo);
	}

	
}

	