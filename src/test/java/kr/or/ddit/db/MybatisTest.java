package kr.or.ddit.db;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.Mybatis.MybatisUtil;

public class MybatisTest {

	@Test
	public void getSqlSessiontest() {
		/***Given***/
		
		
		/***When***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		
		/***Then***/
		assertNotNull(sqlSession);
		
	}
}
