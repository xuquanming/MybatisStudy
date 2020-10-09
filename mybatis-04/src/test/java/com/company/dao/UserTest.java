package com.company.dao;

import com.company.pojo.User;
import com.company.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void getUserByLimit(){
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map= new HashMap<String, Integer>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList= mapper.getUserByLimit(map);
        userList.forEach(System.out::println);
        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds(){
        //获取session对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        RowBounds rowBounds = new RowBounds(1,2);


        //通过java代码层实现分页
        List<User> userList =  sqlSession.selectList("com.company.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        userList.forEach(System.out::println);
        sqlSession.close();
    }
}
