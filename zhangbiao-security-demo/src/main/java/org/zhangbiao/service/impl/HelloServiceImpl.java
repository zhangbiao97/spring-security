package org.zhangbiao.service.impl;

import org.springframework.stereotype.Service;
import org.zhangbiao.service.HelloService;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 20:46
 */
@Service
public class HelloServiceImpl implements HelloService {

    @Override
    public String greetings(String name) {
        System.out.println("greetings");
        return name;
    }

}
