package info.zoio.hackathon.wealthradius.core.mappers;

import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import info.zoio.hackathon.wealthradius.core.BaseTest;
import info.zoio.hackathon.wealthradius.core.mappers.pojo.UserInfo;
import lombok.extern.slf4j.Slf4j;

/**
 *
 * 类名: UserInfoMapperTest <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
*/
@Slf4j
public class UserInfoMapperTest extends BaseTest{
	@Autowired
	private UserInfoMapper userInfoMapper;
	/**
	 * Test method for {@link tk.mybatis.mapper.common.base.select.SelectOneMapper#selectOne(java.lang.Object)}.
	 */
	@Test
	public void testSelectOne() {
		UserInfo userInfo =  new UserInfo();
		userInfo.setMobileNo("18500001234");
		userInfo = userInfoMapper.selectOne(userInfo);
		log.info("UserInfoMapperTest.testSelectOne,{}",userInfo!=null?userInfo.toString():"no data");
		
	}

	/**
	 * Test method for {@link tk.mybatis.mapper.common.base.insert.InsertMapper#insert(java.lang.Object)}.
	 */
	@Test
	@Rollback(false)
	public void testInsert() {
		UserInfo userInfo =  new UserInfo();
		userInfo.setMobileNo("18500001234");
		userInfo.setCreateDate(new Date());
		
		userInfo.setNickName("1234");
		userInfoMapper.insert(userInfo);
	}

}

	