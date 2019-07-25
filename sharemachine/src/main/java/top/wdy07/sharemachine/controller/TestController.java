package top.wdy07.sharemachine.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wdy07.sharemachine.entity.User;
import top.wdy07.sharemachine.service.UserTestService;
import top.wdy07.sharemachine.shiro.EncryptUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TestController {
    Integer uid = 0;
@Autowired
    UserTestService userTestService;
    @RequestMapping("/regist")
    public String regist(Model model) {
      User loginUser = new User();
        model.addAttribute(loginUser);
        return "regist";
    }

    @RequestMapping(value = "/registSuccess", method = RequestMethod.POST)
    public String success(User loginUser, Model model) {
        System.out.println(loginUser.toString());
        loginUser.setPasswd(EncryptUtils.encrypt(loginUser.getUsername(),loginUser.getPasswd()).toString());
        System.out.println(loginUser.toString());
        userTestService.insert(loginUser);
        return "registSuccess";
    }

    //用户登录
    @RequestMapping("/loginUser")
    public String loginUser(User user,
                            HttpSession session,Model model) {
        //把前端输入的username和password封装为token
        System.out.println("11111111111111111111111111");
        System.out.println(user.toString());
        String username =user.getUsername();
        String password = user.getPasswd();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            model.addAttribute("username",username);
            User userid = userTestService.findByUsername(username);
            model.addAttribute("uid",userid.getUid());
            System.out.println(userid.getUid());
            String list = userTestService.getUserTaskList(userid.getUid());
            model.addAttribute("list",list);
            return "index";
        } catch (Exception e) {
            return "login";
        }
    }
//未认证界面
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    //退出登录
    @RequestMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        return "login";
    }

    //访问login时跳到login
    @RequestMapping("/login")
    public String login(Model model) {
        User user = new User();
        model.addAttribute(user);
        return "login";
    }

    //admin角色才能访问
    @RequestMapping("/admin")
    @ResponseBody
    public String admin() {
        return "admin success";
    }

    //有delete权限才能访问
    @RequestMapping("/edit")
    @ResponseBody
    public String edit() {
        return "edit success";
    }

    @RequestMapping("/test")
    @ResponseBody
    @RequiresRoles("guest")
    public String test(){
        return "test success";
    }


    @RequestMapping(value = {"/user"},method = RequestMethod.GET)
    @ResponseBody
    public String getUserById(@RequestParam(name = "id",defaultValue = "10000") String id){
        String resultUser = userTestService.getUserById(id);
        if(!resultUser.equals("null")){
            return resultUser;
        }
        return "no such User";
    }

    @RequestMapping("/getUserTaskList")
    public String getUserTaskList(String uid,Model model) {
        return userTestService.getUserTaskList(uid);
//        model.addAttribute(loginUser);
    }
}