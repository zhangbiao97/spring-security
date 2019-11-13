package org.zhangbiao.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.zhangbiao.service.HelloService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author: zhangbiao
 * @createTime: 2019/11/13 20:44
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint,Object> {

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my constraint init");
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String name = helloService.greetings("李四");
        System.out.println(name);
        return false;
    }
}
