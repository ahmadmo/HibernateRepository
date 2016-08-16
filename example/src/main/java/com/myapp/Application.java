package com.myapp;

import com.myapp.model.User;
import com.myapp.service.DuplicateEmailAddressException;
import com.myapp.service.InvalidDataEntryException;
import com.myapp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataIntegrityViolationException;

/**
 * @author ahmad
 */
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        UserService userService = (UserService) context.getBean("userService");
        try {
            User newUser = userService.register("ahmad.mozafarnia@gmail.com", "ahmad123456");
            System.out.println("registration successful. User[" + newUser.getId() + "]");
        } catch (InvalidDataEntryException | DuplicateEmailAddressException e) {
            System.out.println("registration failed. due to: " + e);
        }

        User result = userService.findByEmail("ahmad.mozafarnia@gmail.com");
        System.out.println(result);
    }

}
