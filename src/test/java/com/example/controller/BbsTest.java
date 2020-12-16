package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.dao.BbsDao;
import com.example.vo.BbsVO;

import lombok.extern.java.Log;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log
class BbsTest {
	@Autowired
	private SqlSession sqlSession;

	@Autowired
	private BbsDao bbsDao;
	
	@Test
	void test() {
		BbsVO bbsVO = new BbsVO();
		bbsVO.setTitle("제목 테스트 3");
		bbsVO.setContent("내용 테스트 3");
		bbsVO.setEmail("ccc@ccc.com");
		bbsVO.setUserid("javaexpert");
		this.sqlSession.insert("Bbs.insertSP", bbsVO);
		assertEquals(3, this.bbsDao.selectAllBoard().size());
	}

}
