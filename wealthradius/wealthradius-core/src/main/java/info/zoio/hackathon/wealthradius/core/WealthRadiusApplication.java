package info.zoio.hackathon.wealthradius.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 *
 * 类名: WealthRadiusApplication <br/>
 * 用途: TODO 添加用途(可选). <br/>
 * 使用方式: TODO 编写使用demo(可选). <br/>
 *
 * @author Finn <br/>
 */
@MapperScan(basePackages = { "info.zoio.hackathon.wealthradius.core.mappers" })
//@EnableSwagger2
@SpringBootApplication
public class WealthRadiusApplication {

	public static void main(String[] args) {
		SpringApplication.run(WealthRadiusApplication.class, args);
	}
}
