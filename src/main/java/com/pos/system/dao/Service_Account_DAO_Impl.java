package com.pos.system.dao;

import com.pos.system.dto.Service_Account_DTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Service_Account_DAO_Impl implements IService_Account_DAO {

	private final SqlSession sqlSession;
	
	@Autowired
	public Service_Account_DAO_Impl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<Service_Account_DTO> selectAll() {
		return this.sqlSession.selectList("selectAllAccount");
	}
	
}
