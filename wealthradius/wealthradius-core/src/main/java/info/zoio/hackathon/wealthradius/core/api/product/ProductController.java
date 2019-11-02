package info.zoio.hackathon.wealthradius.core.api.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import info.zoio.hackathon.wealthradius.core.commons.ApiResultCode;
import info.zoio.hackathon.wealthradius.core.commons.CommonApiResult;
import info.zoio.hackathon.wealthradius.core.service.OrderService;
import info.zoio.hackathon.wealthradius.core.service.ProductService;
import info.zoio.hackathon.wealthradius.core.service.bean.ProductInfoBean;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: ProductController <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
@Slf4j
@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	@Autowired
	private OrderService orderService;
	//查询银行理财产品列表信息
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/product/getProductInfoList", produces = "application/json; charset=utf-8")
	public CommonApiResult<List<ProductInfoBean>> getProductInfoList(){
    	log.info("开始访问产品列表信息");
    	List<ProductInfoBean> list = productService.getProductInfoList();
    	if(list != null && list.size()>0){
    		for (ProductInfoBean productInfoBean : list) {
    			//查询购买人数
        		Integer count = orderService.countOrderByProductId(productInfoBean.getProductId());
        		productInfoBean.setBuyCount(count);
			}
    		
    		log.info("完成访问产品列表信息，共有{}条产品",list.size());
    		return CommonApiResult.createSuccessDataResult(list);
    	}else{
    		log.info("完成访问产品列表信息，没有产品列表");
    		return CommonApiResult.createErrResult(ApiResultCode.PRODUCT_NOT_EXIST);
    	}
	}
    
    //根据产品id查询产品信息
    @RequestMapping(method = {RequestMethod.GET,RequestMethod.POST}, value = "/api/product/getProductInfoByProductId", produces = "application/json; charset=utf-8")
    public  CommonApiResult<ProductInfoBean> getProductInfoByProductId(Long productId){ 
    	log.info("请求productId={}的产品信息开始",productId);
    	if(productId == null){
    		return CommonApiResult.createErrResult(ApiResultCode.PARAM_IS_NULL);
    	}
    	
    	ProductInfoBean productInfoBean = productService.getProductInfoByProductId(productId);
    	
    	if(productInfoBean!=null){
    		//查询购买人数
    		Integer count = orderService.countOrderByProductId(productId);
    		productInfoBean.setBuyCount(count);
    		log.info("请求productId={}的产品信息完成，info={}",productId,productInfoBean.toString());
    		return CommonApiResult.createSuccessDataResult(productInfoBean);
    	}else{
    		log.info("请求productId={}的产品信息,没有产品数据",productId);
    		return CommonApiResult.createErrResult(ApiResultCode.PRODUCT_NOT_EXIST);
    	}
    }
}

	