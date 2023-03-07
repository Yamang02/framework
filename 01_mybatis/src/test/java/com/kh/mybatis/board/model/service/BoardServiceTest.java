package com.kh.mybatis.board.model.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.kh.mybatis.board.model.vo.Board;
import com.kh.mybatis.common.util.PageInfo;

@DisplayName("BoardService 테스트")
@TestMethodOrder(OrderAnnotation.class)
class BoardServiceTest {

	private BoardService service;

	@BeforeEach
	void setUp() {
		service = new BoardService();
	}

	@Test
	@Disabled
	void noting() {
	}

	@Test
	void create() {

		assertThat(service).isNotNull();
	}

	@Test
	@Order(1)
	@DisplayName("게시글수 조회 테스트")
	void getBoardCountTest() {
		int count = 0;

		count = service.getBoardCount();

		assertThat(count).isGreaterThan(0);

	}

	@Test
	@Order(2)
	@DisplayName("게시글 목록 조회 테스트")
	void findAllTest() {
		List<Board> list = null;
		PageInfo pageInfo = null;
		int listCount = 0;

		listCount = service.getBoardCount();
		pageInfo = new PageInfo(1, 10, listCount, 10);
		list = service.findAll(pageInfo);

		assertThat(list).isNotEmpty();
		assertThat(list.size()).isEqualTo(10);
	}

	@ParameterizedTest
	@CsvSource(value = {
			"null, null, null",
			"ad, null, null",
			"null, 50, null",
			"null, null, 10"
	}, nullValues = "null")
	@Order(3)
	@DisplayName("게시글 수 조회(검색 기능 적용) 테스트")
	void getBoardCountTest(String writer, String title, String content) {
		int count = 0;

		count = service.getBoardCount(writer, title, content);

		System.out.println(count);
		assertThat(count).isGreaterThan(0);
	}

	@ParameterizedTest
	@CsvSource(value = {
			"null, null, null",
			"ad, null, null",
			"null, 50, null",
			"null, null, 10"
	}, nullValues = "null")
	@Order(4)
	@DisplayName("게시글 목록 조회(검색 기능 적용) 테스트")
	void findAllTest(String writer, String title, String content) {

		List<Board> list = null;

		list = service.findAll(writer, title, content);

		assertThat(list).isNotNull().isNotEmpty();

	}

}
