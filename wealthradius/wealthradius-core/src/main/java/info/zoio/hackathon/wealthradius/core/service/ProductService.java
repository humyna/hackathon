package info.zoio.hackathon.wealthradius.core.service;

import java.util.List;

import info.zoio.hackathon.wealthradius.core.service.bean.ProductInfoBean;

/**
 *
 * 类名: ProductService <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 11:23:50 AM
*/
public interface ProductService {
	//TODO 查询产品列表
	public List<ProductInfoBean> getProductInfoList();
	
	//TODO 根据产品id查询产品详情
	public ProductInfoBean getProductInfoByProductId(Long productId);
}

	