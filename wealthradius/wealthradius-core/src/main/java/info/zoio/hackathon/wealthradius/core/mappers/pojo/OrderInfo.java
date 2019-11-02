package info.zoio.hackathon.wealthradius.core.mappers.pojo;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "order_info")
public class OrderInfo {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "JDBC")
    private Long orderId;

    /**
     *  产品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 起息时间
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     *  到期时间(0点)
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 支付金额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 购买份数
     */
    @Column(name = "buy_unit")
    private Integer buyUnit;

    /**
     * 购买时间
     */
    @Column(name = "pay_date")
    private Date payDate;

    /**
     * 购买方式（0单独购买、拼团1）
     */
    @Column(name = "buy_type")
    private String buyType;

    /**
     * 拼团id
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 支付状态（未支付0、支付成功1、支付失败2）
     */
    @Column(name = "pay_state")
    private String payState;

    /**
     *  订单状态（等待支付0、计息中1、已退出2）
     */
    @Column(name = "order_state")
    private String orderState;

    /**
     * 预计到期收益
     */
    @Column(name = "estimated_earnings")
    private BigDecimal estimatedEarnings;

    /**
     * 奖励收益
     */
    @Column(name = "reward_income")
    private BigDecimal rewardIncome;

    /**
     * 实际退出收益
     */
    @Column(name = "actual_earnings")
    private BigDecimal actualEarnings;

    /**
     * 退出时间
     */
    @Column(name = "exit_time")
    private Date exitTime;

    /**
     * 备注
     */
    private String comments;

    /**
     * @return order_id
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * 获取 产品id
     *
     * @return product_id -  产品id
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * 设置 产品id
     *
     * @param productId  产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 获取起息时间
     *
     * @return start_date - 起息时间
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置起息时间
     *
     * @param startDate 起息时间
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取 到期时间(0点)
     *
     * @return end_date -  到期时间(0点)
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置 到期时间(0点)
     *
     * @param endDate  到期时间(0点)
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取创建时间
     *
     * @return create_date - 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建时间
     *
     * @param createDate 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取购买份数
     *
     * @return buy_unit - 购买份数
     */
    public Integer getBuyUnit() {
        return buyUnit;
    }

    /**
     * 设置购买份数
     *
     * @param buyUnit 购买份数
     */
    public void setBuyUnit(Integer buyUnit) {
        this.buyUnit = buyUnit;
    }

    /**
     * 获取购买时间
     *
     * @return pay_date - 购买时间
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置购买时间
     *
     * @param payDate 购买时间
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    /**
     * 获取购买方式（0单独购买、拼团1）
     *
     * @return buy_type - 购买方式（0单独购买、拼团1）
     */
    public String getBuyType() {
        return buyType;
    }

    /**
     * 设置购买方式（0单独购买、拼团1）
     *
     * @param buyType 购买方式（0单独购买、拼团1）
     */
    public void setBuyType(String buyType) {
        this.buyType = buyType == null ? null : buyType.trim();
    }

    /**
     * 获取拼团id
     *
     * @return group_id - 拼团id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置拼团id
     *
     * @param groupId 拼团id
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取支付状态（支付中0、支付成功1、支付失败2）
     *
     * @return pay_state - 支付状态（支付中0、支付成功1、支付失败2）
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 设置支付状态（支付中0、支付成功1、支付失败2）
     *
     * @param payState 支付状态（支付中0、支付成功1、支付失败2）
     */
    public void setPayState(String payState) {
        this.payState = payState == null ? null : payState.trim();
    }

    /**
     * 获取 订单状态（等待支付0、计息中1、已退出2）
     *
     * @return order_state -  订单状态（等待支付0、计息中1、已退出2）
     */
    public String getOrderState() {
        return orderState;
    }

    /**
     * 设置 订单状态（等待支付0、计息中1、已退出2）
     *
     * @param orderState  订单状态（等待支付0、计息中1、已退出2）
     */
    public void setOrderState(String orderState) {
        this.orderState = orderState == null ? null : orderState.trim();
    }

    /**
     * 获取预计到期收益
     *
     * @return estimated_earnings - 预计到期收益
     */
    public BigDecimal getEstimatedEarnings() {
        return estimatedEarnings;
    }

    /**
     * 设置预计到期收益
     *
     * @param estimatedEarnings 预计到期收益
     */
    public void setEstimatedEarnings(BigDecimal estimatedEarnings) {
        this.estimatedEarnings = estimatedEarnings;
    }

    /**
     * 获取奖励收益
     *
     * @return reward_income - 奖励收益
     */
    public BigDecimal getRewardIncome() {
        return rewardIncome;
    }

    /**
     * 设置奖励收益
     *
     * @param rewardIncome 奖励收益
     */
    public void setRewardIncome(BigDecimal rewardIncome) {
        this.rewardIncome = rewardIncome;
    }

    /**
     * 获取实际退出收益
     *
     * @return actual_earnings - 实际退出收益
     */
    public BigDecimal getActualEarnings() {
        return actualEarnings;
    }

    /**
     * 设置实际退出收益
     *
     * @param actualEarnings 实际退出收益
     */
    public void setActualEarnings(BigDecimal actualEarnings) {
        this.actualEarnings = actualEarnings;
    }

    /**
     * 获取退出时间
     *
     * @return exit_time - 退出时间
     */
    public Date getExitTime() {
        return exitTime;
    }

    /**
     * 设置退出时间
     *
     * @param exitTime 退出时间
     */
    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
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