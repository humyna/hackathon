package info.zoio.hackathon.wealthradius.core.mappers;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import info.zoio.hackathon.wealthradius.core.BaseTest;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.GroupInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: GroupInfoMapperTest <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 * Oct 23, 2019 7:18:02 PM
*/
@Slf4j
public class GroupInfoMapperTest extends BaseTest{
	@Autowired
	private GroupInfoMapper groupInfoMapper;
	/**
	 * Test method for {@link tk.mybatis.mapper.common.base.select.SelectOneMapper#selectOne(java.lang.Object)}.
	 */
	@Test
	public void testSelectOne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link tk.mybatis.mapper.common.base.insert.InsertMapper#insert(java.lang.Object)}.
	 */
	@Test
	public void testInsert() {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setProductId(2L);
		groupInfo.setSponsorUserId(3L);
		groupInfo.setGroupNum(2);
		groupInfo.setGroupState("0");
		groupInfo.setCreateDate(new Date());
		groupInfo.setPayDate(new Date());
		groupInfo.setComments("测试插入");
		groupInfoMapper.insert(groupInfo);
		
	}

}

	