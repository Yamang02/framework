package com.kh.mybatis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App {
	public static Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		System.out.println("Hello World!");
		log.info("Hello SLF4J");
		log.debug("Hello SLF4J - DEBUG");

		//        int count = 0;
		//        SqlSession session = getSession();
		//        
		//        count = session.selectOne("memberMapper.selectCount");
		//        
		//        System.out.println("Count : " + count);
	}
}
