package info.zoio.hackathon.wealthradius.core.service.bean;

import java.math.BigDecimal;

import javax.persistence.Column;

/**
 *
 * 类名: IncomeInfo <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 12:25:17 PM
*/
public class IncomeInfoBean {
	private Long  userId;
	/**
	 * 收益
	 */
	private BigDecimal income;
	/**
	 * 投资金额
	 */
	private BigDecimal investAmount;
	/**
	 * 昵称
	 */
	private String nickName;
	
	 /**
     * 时间类型(0天 1 月 2年)
     */
    private String dateType;
    /**
     * 封闭期
     */
    private Integer closedPeriod;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public BigDecimal getIncome() {
		return income;
	}
	public void setIncome(BigDecimal income) {
		this.income = income;
	}
	public BigDecimal getInvestAmount() {
		return investAmount;
	}
	public void setInvestAmount(BigDecimal investAmount) {
		this.investAmount = investAmount;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
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
    
}

	