package com.java.Main;

import com.java.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.InputStream;


public class MybatisFirst{
    @Test
    public void selectUserById() throws Exception
    {
        //读取配置文件
        //全局配置文件的路径

      InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
      //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //调用SqlSession的增删改查方法
        User user = sqlSession.selectOne("test.selectUserById",1);
        System.out.println(user);
        sqlSession.close();



    }
}
