package com.company.dao;

import com.company.pojo.User;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class UserTest {

    static Logger logger = Logger.getLogger(UserTest.class);
    @Test
    public void test(){

        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //方式一，getmapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        //关闭
        sqlSession.close();
    }

    @Test
    public void testLog4j(){

        logger.info("info:进入了testLog4j");
        logger.debug("debug:进入了testLog4j");
        logger.error("error:进入了testLog4j");
    }
}
