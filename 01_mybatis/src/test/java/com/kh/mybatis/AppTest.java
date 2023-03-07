package com.kh.mybatis;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.kh.mybatis.common.template.SqlSessionTemplate;

@DisplayName("첫 번재 테스트 코드 작성")
public class AppTest {
	@Test
	@Disabled
	public void nothing() {
		// 현재 프로젝트 환경이 테스트를 진행할 수 있는 환경인지 확인한다.
	}

	@Test
	@DisplayName("SqlSession 생성 테스트")
	public void create() {
		SqlSession session = SqlSessionTemplate.getSession();

//		System.out.println(session);
		assertNotNull(session);
		assertEquals(10, 10);
		org.assertj.core.api.Assertions.assertThat(10).isEqualTo(10);
	}

}