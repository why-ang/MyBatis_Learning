import com.itheima.dao.IAccountDao;
import com.itheima.dao.IuserDao;
import com.itheima.domain.Account;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {

    private InputStream in;
    private SqlSession session;
    private IAccountDao accountDao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        session = new SqlSessionFactoryBuilder().build(in).openSession(true);
        accountDao = session.getMapper(IAccountDao.class);
        }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<Account> accounts = accountDao.findAll();
        for (Account account: accounts){
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void findById(){
        Account account = accountDao.findById(46);
        System.out.println(account);
    }

//    @Test
//    public void updataUser(){
//        User user = new User();
//        user.setUsername("丽丽力");
//        user.setSex("女");
//        user.setAddress("天津");
//        user.setBirthday(new Date());
//        user.setId(51);
//        userdao.updataUser(user);
//    }




}
