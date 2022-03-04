package org.alvin.app02mybatis.mapper;

import org.alvin.app02mybatis.pojo.Blog;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class BlogMapperTest {

    SqlSessionFactory sqlSessionFactory;

    @Before
    public void init() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testSelectBlog() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Blog blog = sqlSession.selectOne("org.alvin.app02mybatis.mapper.BlogMapper.selectBlog", 1);
            System.out.println(blog);
        }
    }

    @Test
    public void testInsertBlog() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            Blog blog = new Blog("MyBatis 学习指南", 104);
            int insertRows = sqlSession.insert("org.alvin.app02mybatis.mapper.BlogMapper.insertBlog", blog);
            System.out.println("The number of rows affected by the insert: " + insertRows);
            sqlSession.commit(); // commit transaction manually or the insert would not be persisted.
        }
    }
}
