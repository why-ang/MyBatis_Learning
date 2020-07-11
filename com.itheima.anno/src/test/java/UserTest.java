import com.itheima.dao.IuserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {

    private InputStream in;
    private SqlSession session;
    private IuserDao userdao;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        session = new SqlSessionFactoryBuilder().build(in).openSession(true);
        userdao = session.getMapper(IuserDao.class);
        }

    @After
    public void destroy() throws IOException {
        session.close();
        in.close();
    }

    @Test
    public void findAll(){
        List<User> users = userdao.findAll();
        for (User user: users){
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void findById(){
        User user = userdao.findById(46);
        System.out.println(user);
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
