package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.UserMapper;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.entity.User;
import xyz.somedefinitions.ejile.service.UserService;

import javax.annotation.Resource;
import java.time.LocalDate;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public RequestResult<User> login(User user) {
        User user1 = userMapper.selectByUsernameAndPassword(user);
        return new RequestResult<>(user1!=null,user1,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> add(User user) {
        User user1 = userMapper.selectByUsername(user.getUsername());
        if (user1 != null) {
            return new RequestResult<>(false,null,"用户名冲突！");
        }
        User user2 = userMapper.selectByMobile(user.getMobile());
        if (user2 != null) {
            return new RequestResult<>(false,null,"手机号被占用！");
        }
        user.setCreateTime(LocalDate.now());
        user.setUpdateTime(LocalDate.now());
        user.setBalance(10000);
        int r = userMapper.insert(user);
        return new RequestResult<>(r>0,null,"");
    }

    @Transactional
    @Override
    public RequestResult<Void> update(User user) {
        User u = userMapper.selectByPrimaryKey(user.getId());
        if (u == null) {
            return new RequestResult<>(false,null,"没有该用户！");
        }
        if (user.getNickname() != null && !user.getNickname().equals("")) {
            u.setNickname(user.getNickname());
        }
        if (user.getAddress() != null && !user.getAddress().equals("")) {
            u.setAddress(user.getAddress());
        }
        u.setUpdateTime(LocalDate.now());
        int r = userMapper.update(u);
        return new RequestResult<>(r>0,null,"");
    }
}
