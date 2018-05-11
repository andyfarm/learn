package com.machengjie.clonenote;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 马成杰
 */
@SpringBootApplication
@MapperScan("mapper/UserMapper.xml")
public class ClonenoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClonenoteApplication.class, args);
	}
}
