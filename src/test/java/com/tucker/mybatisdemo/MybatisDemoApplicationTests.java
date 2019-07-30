package com.tucker.mybatisdemo;

import com.tucker.mybatisdemo.bean.User;
import com.tucker.mybatisdemo.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisDemoApplicationTests {

    @Test
    public void contextLoads() throws IOException {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder sqlSessionFactory = new SqlSessionFactoryBuilder();
        //3.使用工厂生产SqlSession对象
        SqlSessionFactory factory = sqlSessionFactory.build(in);
        //4.使用SqlSession创建Dao接口的代理对象
        SqlSession openSession = factory.openSession();
        //5.使用代理对象执行方法
        IUserDao userDao = openSession.getMapper(IUserDao.class);

        List<User> users  = userDao.findAll();
        for (User user:users){
            System.out.println(user);
        }
        //6.释放资源
        openSession.close();
        in.close();

    }


    @Test
    public void test(){
        System.out.println("com/tucker/test".substring(5));
    }
}
