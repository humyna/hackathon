package info.zoio.hackathon.wealthradius.core.api.order;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.zoio.hackathon.wealthradius.core.commons.ApiResultCode;
import info.zoio.hackathon.wealthradius.core.commons.CommonApiResult;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.OrderInfo;
import info.zoio.hackathon.wealthradius.core.service.OrderService;
import info.zoio.hackathon.wealthradius.core.service.bean.IncomeInfoBean;
import info.zoio.hackathon.wealthradius.core.service.bean.OrderInfoBean;
import info.zoio.hackathon.wealthradius.core.service.bean.ProductInfoBean;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: OrderController <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
@Slf4j
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;
	
	//TODO 根据用户id查询投资明细
	@RequestMapping(method = {RequestMethod.GET}, value = "/api/order/getOrderListByUserId", produces = "application/json; charset=utf-8")
	public CommonApiResult<List<OrderInfoBean>> getOrderListByUserId(Long userId){
		 //单笔投资、拼团投资（优先展示）
		log.info("请求用户userId={}的订单信息开始",userId);
    	if(userId == null){
    		return CommonApiResult.createErrResult(ApiResultCode.PARAM_IS_NULL);
    	}
    	List<OrderInfoBean> list = orderService.getOrderInfoBeanListByUserId(userId);
    	if(list != null && list.size()>0){
    		log.info("请求用户userId={}的订单信息完成，共有{}条产品",userId,list.size());
    		return CommonApiResult.createSuccessDataResult(list);
    	}else{
    		log.info("请求用户userId={}的订单信息完成，没有订单列表");
    		return CommonApiResult.createErrResult(ApiResultCode.ORDER_NOT_LEGAL);
    	}	 }
	
	// 查询附近的人收益的接口
	 @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/order/getIncomeInfoList", produces = "application/json; charset=utf-8")
	public CommonApiResult<List<IncomeInfoBean>> getIncomeInfoList(){
		List<IncomeInfoBean> incomeInfoBeans = new ArrayList<IncomeInfoBean>();
		IncomeInfoBean incomeInfoBean = new IncomeInfoBean();
		incomeInfoBean.setUserId(32L);
		incomeInfoBean.setNickName("张先生");
		incomeInfoBean.setInvestAmount(new BigDecimal(100000));
		incomeInfoBean.setDateType("1");
		incomeInfoBean.setClosedPeriod(12);
		incomeInfoBean.setIncome(new BigDecimal(1150));
		IncomeInfoBean incomeInfoBean1 = new IncomeInfoBean();
		incomeInfoBean1.setUserId(32L);
		incomeInfoBean1.setNickName("王女士");
		incomeInfoBean1.setInvestAmount(new BigDecimal(10000));
		incomeInfoBean1.setDateType("1");
		incomeInfoBean1.setClosedPeriod(24);
		incomeInfoBean.setIncome(new BigDecimal(2400));
		incomeInfoBeans.add(incomeInfoBean);
		incomeInfoBeans.add(incomeInfoBean1);
		return CommonApiResult.createSuccessDataResult(incomeInfoBeans);
	}
}

	