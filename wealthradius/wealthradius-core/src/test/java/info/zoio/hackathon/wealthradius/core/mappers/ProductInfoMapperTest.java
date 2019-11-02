package info.zoio.hackathon.wealthradius.core.mappers;

import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.zoio.hackathon.wealthradius.core.BaseTest;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.ProductInfo;

/**
 *
 * 类名: ProductInfoMapperTest <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 23, 2019 6:58:05 PM
*/
public class ProductInfoMapperTest extends BaseTest{
	@Autowired
	private ProductInfoMapper productInfoMapper;
	/**
	 * Test method for {@link tk.mybatis.mapper.common.base.select.SelectOneMapper#selectOne(java.lang.Object)}.
	 */
	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tk.mybatis.mapper.common.base.insert.InsertMapper#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		ProductInfo productInfo =  new ProductInfo();
		productInfo.setProductName("银行理财-18");
		productInfo.setClosedPeriod(24);
		productInfo.setCreateDate(new Date());
		productInfo.setDateType("1");
		productInfo.setOfferingAmount(100000000L);
		productInfo.setProviderName("建设银行");
		productInfo.setRate(new BigDecimal("4.75"));
		productInfo.setSaleState("0");
		productInfo.setAmountPerUnit(100);
		productInfo.setSaleType("0");
		productInfoMapper.insert(productInfo);
	}

}

	