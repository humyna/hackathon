package info.zoio.hackathon.wealthradius.core.service.bean;

import java.util.Date;

/**
 *
 * 类名: GroupInfoBean <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 1:02:20 PM
*/
public class GroupInfoBean {
	    private Long groupId;
	    /**
	     * 产品id
	     */
	    private Long productId;
	    /**
	     * 发起人id
	     */
	    private Long sponsorUserId;
	    /**
	     * 拼团状态（拼团中0、完成拼团1、拼团失败2）
	     */
	    private String groupState;
	    /**
	     * 拼团规模（人数)
	     */
	    private Integer groupNum;
	    /**
	     * 拼团剩余（人数)
	     */
	    private Integer leftNum;
	    /**
	     *  拼团开始时间（支付成功时间)
	     */
	    private Date payDate;
		public Long getGroupId() {
			return groupId;
		}
		public void setGroupId(Long groupId) {
			this.groupId = groupId;
		}
		public Long getProductId() {
			return productId;
		}
		public void setProductId(Long productId) {
			this.productId = productId;
		}
		public Long getSponsorUserId() {
			return sponsorUserId;
		}
		public void setSponsorUserId(Long sponsorUserId) {
			this.sponsorUserId = sponsorUserId;
		}
		public String getGroupState() {
			return groupState;
		}
		public void setGroupState(String groupState) {
			this.groupState = groupState;
		}
		public Integer getGroupNum() {
			return groupNum;
		}
		public void setGroupNum(Integer groupNum) {
			this.groupNum = groupNum;
		}
		public Integer getLeftNum() {
			return leftNum;
		}
		public void setLeftNum(Integer leftNum) {
			this.leftNum = leftNum;
		}
		public Date getPayDate() {
			return payDate;
		}
		public void setPayDate(Date payDate) {
			this.payDate = payDate;
		}
	    
}

	