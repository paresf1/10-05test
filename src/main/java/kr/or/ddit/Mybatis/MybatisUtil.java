package kr.or.ddit.Mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {

	private static SqlSessionFactory sqlSessionFactory;
	
	//클래스가 로딩이 될 때 가장 먼저 실행되는 것
	//static 블럭을 통해 클래스가 로딩이 될때 mybatis 환경을 구성한다.
	//==> sqlSessionFactory 객체를 생성
	static {
		String resource = "kr/or/ddit/db/mybatis-config.xml";
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// sqlSessionFactory 객체를 통해 sqlSession 객체를 얻어내는 메소드
	
	public static SqlSession getSqlSession() {
		
		return sqlSessionFactory.openSession();
	}
	
	
}














