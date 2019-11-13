package org.zhangbiao.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.zhangbiao.exception.UserNotExistException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 21:45
 */
@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(UserNotExistException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUserNotExistException(UserNotExistException ex, HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        result.put("id",ex.getId());
        result.put("message",ex.getMessage());
        request.setAttribute("ext",result);
        return "forward:/error";
    }

}
