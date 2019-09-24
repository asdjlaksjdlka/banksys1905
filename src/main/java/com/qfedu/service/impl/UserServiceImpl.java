package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.redis.RedisService;
import com.qfedu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisService redisService;

    @Override
    public User login(String bankCode, String password) {

        User u = userDao.findByCode(bankCode);
        if(u == null){
            throw new RuntimeException("卡号错误");
        }
        if(!u.getPassword().equals(password)){
            throw new RuntimeException("密码错误");
        }
        return u;
    }

    @Override
    public Double findBalance(String bankCode) {

        // 先看redis中是否缓存了余额数据，如果有，直接返回该数据；
        // 如果没有，从数据库中查询，将查到数据放到reids缓存里
        Double balance = redisService.getBalance("balance", bankCode);
        if(balance == null){
            User user = userDao.findByCode(bankCode);
            if(user == null){
                throw new RuntimeException("账号不存在");
            }
            balance = user.getBalance();
            // 放入缓存
            redisService.setBalance("balance", bankCode, balance);
        }
        return balance;
    }
}









