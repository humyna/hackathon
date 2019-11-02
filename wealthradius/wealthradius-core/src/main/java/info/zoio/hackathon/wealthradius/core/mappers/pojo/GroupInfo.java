package info.zoio.hackathon.wealthradius.core.mappers.pojo;

import java.util.Date;
import javax.persistence.*;

@Table(name = "group_info")
public class GroupInfo {
    @Id
    @Column(name = "group_id")
    @GeneratedValue(generator = "JDBC")
    private Long groupId;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 发起人id
     */
    @Column(name = "sponsor_user_id")
    private Long sponsorUserId;

    /**
     * 拼团状态（拼团中0、完成拼团1、拼团失败2）
     */
    @Column(name = "group_state")
    private String groupState;

    /**
     * 拼团规模（人数)
     */
    @Column(name = "group_num")
    private Integer groupNum;

    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     *  拼团开始时间（支付成功时间)
     */
    @Column(name = "pay_date")
    private Date payDate;

    /**
     * 备注
     */
    private String comments;

    /**
     * @return group_id
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

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
     * 获取发起人id
     *
     * @return sponsor_user_id - 发起人id
     */
    public Long getSponsorUserId() {
        return sponsorUserId;
    }

    /**
     * 设置发起人id
     *
     * @param sponsorUserId 发起人id
     */
    public void setSponsorUserId(Long sponsorUserId) {
        this.sponsorUserId = sponsorUserId;
    }

    /**
     * 获取拼团状态（拼团中0、完成拼团1、拼团失败2）
     *
     * @return group_state - 拼团状态（拼团中0、完成拼团1、拼团失败2）
     */
    public String getGroupState() {
        return groupState;
    }

    /**
     * 设置拼团状态（拼团中0、完成拼团1、拼团失败2）
     *
     * @param groupState 拼团状态（拼团中0、完成拼团1、拼团失败2）
     */
    public void setGroupState(String groupState) {
        this.groupState = groupState == null ? null : groupState.trim();
    }

    /**
     * 获取拼团规模（人数)
     *
     * @return group_num - 拼团规模（人数)
     */
    public Integer getGroupNum() {
        return groupNum;
    }

    /**
     * 设置拼团规模（人数)
     *
     * @param groupNum 拼团规模（人数)
     */
    public void setGroupNum(Integer groupNum) {
        this.groupNum = groupNum;
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
     * 获取 拼团开始时间（支付成功时间)
     *
     * @return pay_date -  拼团开始时间（支付成功时间)
     */
    public Date getPayDate() {
        return payDate;
    }

    /**
     * 设置 拼团开始时间（支付成功时间)
     *
     * @param payDate  拼团开始时间（支付成功时间)
     */
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
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