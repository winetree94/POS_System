package com.pos.system.util;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SqlSessionTemplate_Comm {
	
	@Autowired
	protected SqlSessionTemplate session;
	
}
