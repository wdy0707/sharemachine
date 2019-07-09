package top.wdy07.sharemachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wdy07.sharemachine.entity.User;
import top.wdy07.sharemachine.entity.UserExample;
import top.wdy07.sharemachine.mapper.UserMapper;

/**
 * @author wdy
 * @create 2019-07-09 13:51
 */
@Service
public class UserTestService {

    @Autowired
    private UserMapper userMapper;

    public User getUserById(String id){
        return userMapper.selectByPrimaryKey(id);
    }
}
