package info.zoio.hackathon.wealthradius.core.service;

import java.math.BigDecimal;
import java.util.List;

import info.zoio.hackathon.wealthradius.core.service.bean.GroupInfoBean;

/**
 *
 * 类名: GroupService <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 25, 2019 1:00:29 PM
*/
public interface GroupService {
	//根据状态查询开团列表信息
	public List<GroupInfoBean> getGroupInfoBeanByState(String state);
	
	public GroupInfoBean getGroupInfoBeanByGroupId(Long groupId);
	
	//开团
	public boolean creatGroup(Long userId,Long productId,BigDecimal investAmount,Integer buyUnit,Integer groupSum);
	
	//参团
	public boolean joinGroup(Long userId,Long groupId,Long productId,BigDecimal investAmount,Integer buyUnit);
	
}

	