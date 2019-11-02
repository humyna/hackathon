package info.zoio.hackathon.wealthradius.core.commons;

/**
 *
 * 类名: GroupStateEnum <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 1:37:39 PM
*/
public enum GroupStateEnum {
	GROUPING("0","拼团中"),
	GROUP_SUCC("1","拼团成功"),
	GROUP_FAILURE("2","拼团失败")
	;
	private String stateValue;
	private String stateName;
	public String getStateName() {
		return stateName;
	}
	public String getStateValue() {
		return stateValue;
	}
	private GroupStateEnum(String stateValue,String stateName) {
		this.stateName = stateName;
		this.stateValue = stateValue;
	}
	
	public static boolean isLegal(String stateValue) {
		for (GroupStateEnum groupStateEnum : GroupStateEnum.values()) {
			if(groupStateEnum.getStateValue().equals(stateValue)){
				return true;
			}
		}
		return false;
	}
}

	