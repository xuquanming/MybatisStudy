package com.company.dao;

import com.company.pojo.User;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

@SuppressWarnings("all")
public class Mytest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);

        sqlSession.clearCache();//手动清理缓存
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);

        System.out.println(user==user2);
        sqlSession.close();

    }


}
