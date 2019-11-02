package info.zoio.hackathon.wealthradius.core.service.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 类名: OrderInfoBean <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 5:38:53 PM
*/
public class OrderInfoBean {
	 private Long orderId;

	    /**
	     *  产品id
	     */
	    private Long productId;

	    /**
	     * 起息时间
	     */
	    private Date startDate;

	    /**
	     *  到期时间(0点)
	     */
	    private Date endDate;

	    /**
	     * 用户id
	     */
	    private Long userId;

	    /**
	     * 创建时间
	     */
	    private Date createDate;

	    /**
	     * 支付金额
	     */
	    private BigDecimal payAmount;

	    /**
	     * 购买份数
	     */
	    private Integer buyUnit;

	    /**
	     * 购买时间
	     */
	    private Date payDate;

	    /**
	     * 购买方式（0单独购买、拼团1）
	     */
	    private String buyType;

	    /**
	     * 拼团id
	     */
	    private Long groupId;

	    /**
	     * 支付状态（未支付0、支付成功1、支付失败2）
	     */
	    private String payState;

	    /**
	     *  订单状态（等待支付0、计息中1、已退出2）
	     */
	    private String orderState;

	    /**
	     * 预计到期收益
	     */
	    private BigDecimal estimatedEarnings;

	    /**
	     * 奖励收益
	     */
	    private BigDecimal rewardIncome;

	    /**
	     * 实际退出收益
	     */
	    private BigDecimal actualEarnings;

	    /**
	     * 退出时间
	     */
	    private Date exitTime;

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public Date getCreateDate() {
			return createDate;
		}

		public void setCreateDate(Date createDate) {
			this.createDate = createDate;
		}

		public BigDecimal getPayAmount() {
			return payAmount;
		}

		public void setPayAmount(BigDecimal payAmount) {
			this.payAmount = payAmount;
		}

		public Integer getBuyUnit() {
			return buyUnit;
		}

		public void setBuyUnit(Integer buyUnit) {
			this.buyUnit = buyUnit;
		}

		public Date getPayDate() {
			return payDate;
		}

		public void setPayDate(Date payDate) {
			this.payDate = payDate;
		}

		public String getBuyType() {
			return buyType;
		}

		public void setBuyType(String buyType) {
			this.buyType = buyType;
		}

		public Long getGroupId() {
			return groupId;
		}

		public void setGroupId(Long groupId) {
			this.groupId = groupId;
		}

		public String getPayState() {
			return payState;
		}

		public void setPayState(String payState) {
			this.payState = payState;
		}

		public String getOrderState() {
			return orderState;
		}

		public void setOrderState(String orderState) {
			this.orderState = orderState;
		}

		public BigDecimal getEstimatedEarnings() {
			return estimatedEarnings;
		}

		public void setEstimatedEarnings(BigDecimal estimatedEarnings) {
			this.estimatedEarnings = estimatedEarnings;
		}

		public BigDecimal getRewardIncome() {
			return rewardIncome;
		}

		public void setRewardIncome(BigDecimal rewardIncome) {
			this.rewardIncome = rewardIncome;
		}

		public BigDecimal getActualEarnings() {
			return actualEarnings;
		}

		public void setActualEarnings(BigDecimal actualEarnings) {
			this.actualEarnings = actualEarnings;
		}

		public Date getExitTime() {
			return exitTime;
		}

		public void setExitTime(Date exitTime) {
			this.exitTime = exitTime;
		}
	    
}

	