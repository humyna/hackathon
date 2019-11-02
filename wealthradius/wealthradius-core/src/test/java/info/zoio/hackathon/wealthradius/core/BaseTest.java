package info.zoio.hackathon.wealthradius.core;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 *
 * 类名: BaseTest <br/>
 * 用途: 测试基类. <br/>
 * 使用方式: 测试类引用这个基类即可. <br/>
 *
 * @author Finn <br/>
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {
	@Autowired
	DataSource dataSource;
	
	@Test
	public void contextLoads() throws SQLException {
		log.info("dataSource class={}",dataSource.getClass());
		Connection connection = dataSource.getConnection();
		
		log.info("connection={}",connection);
		connection.close();
	}
}
