package com.bit2025.jblog.repository;

import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.bit2025.jblog.security.UserDetailsImpl;
import com.bit2025.jblog.vo.UserVo;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;

	public int insert(UserVo userVo) {
		return sqlSession.insert("user.insert", userVo);
	}

    public UserDetails findById(String id, Class<UserDetailsImpl> result) {
    	Map<String, Object> map = sqlSession.selectOne("user.findById", id);
        return new ObjectMapper().convertValue(map, result);
    }


}
