package com.pos.system.dao;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Service_Account_DAO {

	private final SqlSession sqlSession;
	
	public Service_Account_DAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Service_Account_DTO> selectAll() {
		return this.sqlSession.selectList("selectAllAccount");
	}
	
}
