package info.zoio.hackathon.wealthradius.core.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import info.zoio.hackathon.wealthradius.core.mappers.ProductInfoMapper;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.ProductInfo;
import info.zoio.hackathon.wealthradius.core.service.ProductService;
import info.zoio.hackathon.wealthradius.core.service.bean.ProductInfoBean;

/**
 *
 * 类名: ProductServiceImpl <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 11:35:15 AM
*/
@Component
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductInfoMapper productInfoMapper;
	
	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.ProductService#getProductInfoList()
	 * @return
	*/
	@Override
	public List<ProductInfoBean> getProductInfoList() {
		List<ProductInfo> productInfos = productInfoMapper.selectAll();
		List<ProductInfoBean> retList = new ArrayList<ProductInfoBean>();
		
		if(productInfos != null && productInfos.size() > 0){
			for (ProductInfo productInfo : productInfos) {
				ProductInfoBean productInfoBean = new ProductInfoBean();
				productInfoBean.setProductId(productInfo.getProductId());
				productInfoBean.setProductName(productInfo.getProductName());
				productInfoBean.setProviderName(productInfo.getProviderName());
				productInfoBean.setAmountPerUnit(productInfo.getAmountPerUnit());
				productInfoBean.setOfferingAmount(productInfo.getOfferingAmount());
				productInfoBean.setRate(productInfo.getRate());
				productInfoBean.setSaleType(productInfo.getSaleType());
				productInfoBean.setSaleState(productInfo.getSaleState());
				productInfoBean.setDateType(productInfo.getDateType());
				productInfoBean.setClosedPeriod(productInfo.getClosedPeriod());
				retList.add(productInfoBean);
			}
			return retList;
		}
		
		return null;

	}

	/* (non-Javadoc)
	 * @see info.zoio.hackathon.wealthradius.core.service.ProductService#getProductInfoByProductId(java.lang.Long)
	 * @param productId
	 * @return
	*/
	@Override
	public ProductInfoBean getProductInfoByProductId(Long productId) {
		ProductInfo productInfo = new ProductInfo();
		productInfo.setProductId(productId);
		productInfo = productInfoMapper.selectByPrimaryKey(productInfo);
		if(productInfo!=null){
			ProductInfoBean productInfoBean = new ProductInfoBean();
			productInfoBean.setProductId(productInfo.getProductId());
			productInfoBean.setProductName(productInfo.getProductName());
			productInfoBean.setProviderName(productInfo.getProviderName());
			productInfoBean.setAmountPerUnit(productInfo.getAmountPerUnit());
			productInfoBean.setOfferingAmount(productInfo.getOfferingAmount());
			productInfoBean.setRate(productInfo.getRate());
			productInfoBean.setSaleType(productInfo.getSaleType());
			productInfoBean.setSaleState(productInfo.getSaleState());
			productInfoBean.setDateType(productInfo.getDateType());
			productInfoBean.setClosedPeriod(productInfo.getClosedPeriod());
			return productInfoBean;
		}
		return null;
	}

}

	