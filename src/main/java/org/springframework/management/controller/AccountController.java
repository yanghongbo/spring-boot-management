package org.springframework.management.controller;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.management.entity.User;
import org.springframework.management.requestmodel.LoginModel;
import org.springframework.management.requestmodel.RegisterModel;
import org.springframework.management.service.UserService;
import org.springframework.management.viewmodel.Message;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.security.provider.MD5;

@RestController
public class AccountController extends BaseController{
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Message login(@RequestBody LoginModel model) {
        User user = userService.findByNameAndPassword(model.getName(), model.getPassword());
        if (user == null) {
            return fail(-1, "用户名或密码错误");
        } else {
            return success(1, user);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Message register(@RequestBody RegisterModel model) {

        if (userService.isNameExist(model.getName())) {
            return fail(-1, "用户名已存在");
        }

        User newUser = new User();
        newUser.setName(model.getName());
        newUser.setPassword(model.getPassword());
        userService.save(newUser);

        return success();
    }
}
