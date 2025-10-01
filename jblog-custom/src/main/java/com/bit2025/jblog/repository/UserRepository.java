package com.bit2025.jblog.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2025.jblog.vo.PostVo;
import com.bit2025.jblog.vo.UserVo;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class UserRepository {

	@Autowired
	private SqlSession sqlSession;

	public int insert(UserVo userVo) {
		return sqlSession.insert("user.insert", userVo);
	}

    public <R> R findById(String id, Class<R> resultType) {
    	Map<String, Object> map = sqlSession.selectOne("user.findById", id);
        return new ObjectMapper().convertValue(map, resultType);
    }

	public List<PostVo> findAll() {
		return sqlSession.selectList("user.findAll");
	}

}
