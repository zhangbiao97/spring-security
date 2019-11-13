package org.zhangbiao.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.zhangbiao.dto.User;
import org.zhangbiao.dto.UserQueryCondition;
import org.zhangbiao.exception.UserNotExistException;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangbiao
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @DeleteMapping("/{id:\\d}")
    public void delete(@PathVariable Integer id){
        System.out.println(id);
    }

    @PutMapping("/{id:\\d+}")
    public User update(@Valid @RequestBody User user,BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().forEach(error -> {
                FieldError fieldError=(FieldError)error;
                System.out.println(fieldError.getField()+"："+fieldError.getDefaultMessage());
            });
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){
        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error));
        }
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());
        user.setId(1);
        return user;
    }


    @JsonView(User.UserSimpleView.class)
    @GetMapping
    public List<User> query(UserQueryCondition condition, @PageableDefault(page = 1,size = 15,sort = {"age,desc"}) Pageable pageable) {
        System.out.println(condition);
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getSort());
        ArrayList<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @JsonView(User.UserDetailView.class)
    @GetMapping("/{id:\\d+}")
    public User getInfo(@PathVariable("id") Integer id){
        User user = new User();
        user.setUsername("zhangsan");
        return user;
    }

}
