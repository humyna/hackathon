package info.zoio.hackathon.wealthradius.core.commons;

/**
 *
 * 类名: OrderStateEnum <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
public enum OrderStateEnum {
	PAYING("O","等待支付"),
	finaning("1","计息中"),
	EXITED("2","已退出")
	;
	private String stateValue;
	private String stateName;
	public String getStateName() {
		return stateName;
	}
	public String getStateValue() {
		return stateValue;
	}
	private OrderStateEnum(String stateName, String stateValue) {
		this.stateName = stateName;
		this.stateValue = stateValue;
	}
	
	public static boolean isLegal(String stateValue) {
		for (OrderStateEnum orderStateEnum : OrderStateEnum.values()) {
			if(orderStateEnum.getStateValue().equals(stateValue)){
				return true;
			}
		}
		return false;
	}
}

	