package top.wdy07.sharemachine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.wdy07.sharemachine.entity.Permission;
import top.wdy07.sharemachine.entity.Role;
import top.wdy07.sharemachine.entity.User;
import top.wdy07.sharemachine.service.UserTestService;

import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SharemachineApplicationTests {
@Autowired
private UserTestService userTestService;
    @Test
    public void findByUsername() {
        User u = userTestService.findByUsername("jinzhiqaing");
//        User u = userTestService.findByUsername("machengyuan");
        System.out.println(u.toString());
        Set<Role> roleSet = u.getRoles();
        for (Role role : roleSet){
            Set<Permission> permissionSet = role.getPermissions();
            for (Permission permission : permissionSet){
                System.out.println(permission.getName());
            }
            System.out.println(role.getName());
        }
    }
}
