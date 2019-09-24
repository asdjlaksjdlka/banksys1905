package com.qfedu.service;

import com.qfedu.entity.User;

public interface UserService {

    public User login(String bankCode, String password);

    public Double findBalance(String bankCode);
}
