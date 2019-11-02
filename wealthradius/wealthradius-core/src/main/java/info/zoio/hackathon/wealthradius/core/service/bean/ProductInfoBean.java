package info.zoio.hackathon.wealthradius.core.service.bean;

import java.math.BigDecimal;

/**
 *
 * 类名: ProductInfoBean <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 11:26:09 AM
*/
public class ProductInfoBean {
	  /**
     * 产品id
     */
    private Long productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 时间类型(0天 1 月 2年)
     */
    private String dateType;

    /**
     * 封闭期
     */
    private Integer closedPeriod;

    /**
     * 利息rate
     */
    private BigDecimal rate;

    /**
     * 总发售金额(元)
     */
    private Long offeringAmount;

    /**
     * 销售方式 （0 按份数）
     */
    private String saleType;

    /**
     * 每份金额（50)
     */
    private Integer amountPerUnit;

    /**
     * 销售状态（0销售中 1  售罄）
     */
    private String saleState;
    /**
     * 商家名称
     */
    private String providerName;
    
    /**
     * 参团人数
     */
    private Integer buyCount;
	
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public Integer getClosedPeriod() {
		return closedPeriod;
	}
	public void setClosedPeriod(Integer closedPeriod) {
		this.closedPeriod = closedPeriod;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public Long getOfferingAmount() {
		return offeringAmount;
	}
	public void setOfferingAmount(Long offeringAmount) {
		this.offeringAmount = offeringAmount;
	}
	public String getSaleType() {
		return saleType;
	}
	public void setSaleType(String saleType) {
		this.saleType = saleType;
	}
	public Integer getAmountPerUnit() {
		return amountPerUnit;
	}
	public void setAmountPerUnit(Integer amountPerUnit) {
		this.amountPerUnit = amountPerUnit;
	}
	public String getSaleState() {
		return saleState;
	}
	public void setSaleState(String saleState) {
		this.saleState = saleState;
	}
	public String getProviderName() {
		return providerName;
	}
	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	public Integer getBuyCount() {
		return buyCount;
	}
	public void setBuyCount(Integer buyCount) {
		this.buyCount = buyCount;
	}
	@Override
	public String toString() {
		return "ProductInfoBean [productId=" + productId + ", productName=" + productName
				+ ", dateType=" + dateType + ", closedPeriod=" + closedPeriod + ", rate=" + rate
				+ ", offeringAmount=" + offeringAmount + ", saleType=" + saleType
				+ ", amountPerUnit=" + amountPerUnit + ", saleState=" + saleState
				+ ", providerName=" + providerName + ", buyCount=" + buyCount + "]";
	}
	

	
}

	