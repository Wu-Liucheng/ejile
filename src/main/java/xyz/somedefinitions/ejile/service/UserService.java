package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.entity.User;

public interface UserService {
    RequestResult<User> login(User user);
    RequestResult<Void> add(User user);
    RequestResult<Void> update(User user);
}
