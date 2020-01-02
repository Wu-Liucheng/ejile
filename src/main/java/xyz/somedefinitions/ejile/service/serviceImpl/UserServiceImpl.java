package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.UserMapper;
import xyz.somedefinitions.ejile.service.UserService;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
}
