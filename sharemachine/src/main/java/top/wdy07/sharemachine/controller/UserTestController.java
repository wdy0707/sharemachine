package top.wdy07.sharemachine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wdy07.sharemachine.entity.User;
import top.wdy07.sharemachine.service.UserTestService;

/**
 * @author wdy
 * @create 2019-07-09 14:47
 */
@Controller
public class UserTestController {
    @Autowired
    private UserTestService userTestService;

    @RequestMapping(value = {"/user"},method = RequestMethod.GET)
    @ResponseBody
    public User getUserById(@RequestParam(name = "id",defaultValue = "10000") String id){
        return userTestService.getUserById(id);
    }
}
