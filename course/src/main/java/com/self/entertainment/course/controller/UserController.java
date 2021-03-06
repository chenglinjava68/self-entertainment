package com.self.entertainment.course.controller;

import com.self.entertainment.course.common.ResponseData;
import com.self.entertainment.course.dao.entity.User;
import com.self.entertainment.course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author AmazingZ
 * @date 2019/6/1 16:09
 */
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/anon/register", method = RequestMethod.POST)
    public ResponseData<String> register(User User) {
        return userService.addUser(User);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public ResponseData<String> update(User User) {
        return userService.updateUser(User);
    }

    @RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
    public ResponseData<User> getUser() {
        return userService.findByUserId();
    }
}
