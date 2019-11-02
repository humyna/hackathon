package info.zoio.hackathon.wealthradius.core.mappers.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "product_info")
public class ProductInfo {
    /**
     * 产品id
     */
    @Id
    @Column(name = "product_id")
    @GeneratedValue(generator = "JDBC")
    private Long productId;

    /**
     * 产品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 时间类型(0天 1 月 2年)
     */
    @Column(name = "date_type")
    private String dateType;

    /**
     * 封闭期
     */
    @Column(name = "closed_period")
    private Integer closedPeriod;

    /**
     * rate
     */
    private BigDecimal rate;

    /**
     * 总发售金额(元)
     */
    @Column(name = "offering_amount")
    private Long offeringAmount;

    /**
     * 销售方式 （0 按份数）
     */
    @Column(name = "sale_type")
    private String saleType;

    /**
     * 每份金额（50)
     */
    @Column(name = "amount_per_unit")
    private Integer amountPerUnit;

    /**
     * 销售状态（0销售中 1  售罄）
     */
    @Column(name = "sale_state")
    private String saleState;

    @Column(name = "create_date")
    private Date createDate;

    /**
     * 商家名称
     */
    @Column(name = "provider_name")
    private String providerName;

    /**
     * 商家id
     */
    @Column(name = "provider_id")
    private Integer providerId;

    /**
     *  计息规则id
     */
    @Column(name = "interest_rule_id")
    private Integer interestRuleId;

    /**
     * 奖励规则id
     */
    @Column(name = "reward_rule_id")
    private Integer rewardRuleId;

    /**
     * 备注
     */
    private String comments;

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取产品名称
     *
     * @return product_name - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    /**
     * 获取时间类型(0天 1 月 2年)
     *
     * @return date_type - 时间类型(0天 1 月 2年)
     */
    public String getDateType() {
        return dateType;
    }

    /**
     * 设置时间类型(0天 1 月 2年)
     *
     * @param dateType 时间类型(0天 1 月 2年)
     */
    public void setDateType(String dateType) {
        this.dateType = dateType == null ? null : dateType.trim();
    }

    /**
     * 获取封闭期
     *
     * @return closed_period - 封闭期
     */
    public Integer getClosedPeriod() {
        return closedPeriod;
    }

    /**
     * 设置封闭期
     *
     * @param closedPeriod 封闭期
     */
    public void setClosedPeriod(Integer closedPeriod) {
        this.closedPeriod = closedPeriod;
    }

    /**
     * 获取rate
     *
     * @return rate - rate
     */
    public BigDecimal getRate() {
        return rate;
    }

    /**
     * 设置rate
     *
     * @param rate rate
     */
    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    /**
     * 获取总发售金额(元)
     *
     * @return offering_amount - 总发售金额(元)
     */
    public Long getOfferingAmount() {
        return offeringAmount;
    }

    /**
     * 设置总发售金额(元)
     *
     * @param offeringAmount 总发售金额(元)
     */
    public void setOfferingAmount(Long offeringAmount) {
        this.offeringAmount = offeringAmount;
    }

    /**
     * 获取销售方式 （0 按份数）
     *
     * @return sale_type - 销售方式 （0 按份数）
     */
    public String getSaleType() {
        return saleType;
    }

    /**
     * 设置销售方式 （0 按份数）
     *
     * @param saleType 销售方式 （0 按份数）
     */
    public void setSaleType(String saleType) {
        this.saleType = saleType == null ? null : saleType.trim();
    }

    /**
     * 获取每份金额（50)
     *
     * @return amount_per_unit - 每份金额（50)
     */
    public Integer getAmountPerUnit() {
        return amountPerUnit;
    }

    /**
     * 设置每份金额（50)
     *
     * @param amountPerUnit 每份金额（50)
     */
    public void setAmountPerUnit(Integer amountPerUnit) {
        this.amountPerUnit = amountPerUnit;
    }

    /**
     * 获取销售状态（0销售中 1  售罄）
     *
     * @return sale_state - 销售状态（0销售中 1  售罄）
     */
    public String getSaleState() {
        return saleState;
    }

    /**
     * 设置销售状态（0销售中 1  售罄）
     *
     * @param saleState 销售状态（0销售中 1  售罄）
     */
    public void setSaleState(String saleState) {
        this.saleState = saleState == null ? null : saleState.trim();
    }

    /**
     * @return create_date
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * @param createDate
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取商家名称
     *
     * @return provider_name - 商家名称
     */
    public String getProviderName() {
        return providerName;
    }

    /**
     * 设置商家名称
     *
     * @param providerName 商家名称
     */
    public void setProviderName(String providerName) {
        this.providerName = providerName == null ? null : providerName.trim();
    }

    /**
     * 获取商家id
     *
     * @return provider_id - 商家id
     */
    public Integer getProviderId() {
        return providerId;
    }

    /**
     * 设置商家id
     *
     * @param providerId 商家id
     */
    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    /**
     * 获取 计息规则id
     *
     * @return interest_rule_id -  计息规则id
     */
    public Integer getInterestRuleId() {
        return interestRuleId;
    }

    /**
     * 设置 计息规则id
     *
     * @param interestRuleId  计息规则id
     */
    public void setInterestRuleId(Integer interestRuleId) {
        this.interestRuleId = interestRuleId;
    }

    /**
     * 获取奖励规则id
     *
     * @return reward_rule_id - 奖励规则id
     */
    public Integer getRewardRuleId() {
        return rewardRuleId;
    }

    /**
     * 设置奖励规则id
     *
     * @param rewardRuleId 奖励规则id
     */
    public void setRewardRuleId(Integer rewardRuleId) {
        this.rewardRuleId = rewardRuleId;
    }

    /**
     * 获取备注
     *
     * @return comments - 备注
     */
    public String getComments() {
        return comments;
    }

    /**
     * 设置备注
     *
     * @param comments 备注
     */
    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }
}