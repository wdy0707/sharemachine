package top.wdy07.sharemachine.service;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wdy07.sharemachine.dao.DeviceAndTaskDao;
import top.wdy07.sharemachine.entity.User;
import top.wdy07.sharemachine.mapper.UserMapper;

import java.util.List;

/**
 * @author wdy
 * @create 2019-07-09 13:51
 */
@Service
public class UserTestService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DeviceAndTaskDao deviceAndTaskDao;
    public void insert(User user){
        userMapper.insert(user);
    }

    public String getUserById(String id){
        return JSON.toJSONString(userMapper.selectByPrimaryKey(id));
    }

    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
    public String getUserTaskList(String uid){
        System.out.println(uid+"------------------------");
        System.out.println(deviceAndTaskDao.getUserTaskList("3").toString());
        return deviceAndTaskDao.getUserTaskList(uid).toString();

//        return JSON.toJSONString(deviceAndTaskDao.getUserTaskList(uid));
    }
}
