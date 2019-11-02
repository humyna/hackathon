package info.zoio.hackathon.wealthradius.core.service;

import java.util.List;

import info.zoio.hackathon.wealthradius.core.service.bean.OrderInfoBean;

/**
 *
 * 类名: OrderService <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 1:51:03 PM
*/
public interface OrderService {
	//根据groupid查询订单表查询支付成功的记录数
	public Integer countOrderByGroupId(Long groupId);
	//根据productid查询订单表查询支付成功的记录数
	public Integer countOrderByProductId(Long prodcutId);
	
	public List<OrderInfoBean> getOrderInfoBeanListByUserId(Long userId);
}

	