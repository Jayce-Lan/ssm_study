import com.ssm.dao.RoleDao;
import com.ssm.dao.UserDao;
import com.ssm.pojo.Role;
import com.ssm.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
public class MyTest {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    public void test() {
        User user = userDao.selectByPrimaryKey(1);
        Role role = roleDao.selectByPrimaryKey(user.getRoleid());
        user.setRoleName(role.getRolename());
        System.out.println(user);
    }

    @Test
    public void test2() {
        Role role = roleDao.selectById(1);
        System.out.println(role);
    }

    @Test
    public void findAll() {
        List<Role> all = roleDao.findAll();
        for (Role role : all) {
            System.out.println(role.getUserList());
        }
    }
}
