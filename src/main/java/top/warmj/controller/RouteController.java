package top.warmj.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
public class RouteController {

    @RequestMapping({"/", "/index"})
    public String index() {
        System.out.println("index");
        return "index";
    }

    @RequestMapping("/user/addUser")
    public String addUser() {
        return "user/addUser";
    }

    @RequestMapping("/user/updateUser")
    public String updateUser() {
        return "user/updateUser";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/auth")
    public String login(String username, String password, HttpServletRequest request) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token); //执行登录方法
            return "index";
        } catch (UnknownAccountException e) {
            request.setAttribute("msg", "用户名错误");
            return "login";
        } catch (IncorrectCredentialsException e) {
            request.setAttribute("msg", "密码错误");
            return "login";
        }
    }
}
