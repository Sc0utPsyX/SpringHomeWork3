package ru.gb.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v2")
public class HelloTemplateController {

    // Client -> [tomcat server] -> DispatcherServlet -> HelloController
    //        -> DispatcherServlet -> configure html resource -> Client

    // DispatcherServlet

    // http://localhost:8180/app/v1/hello?name=Igor
    // address header params
    @GetMapping("/hello")
    public String hello(Model model, @RequestParam String name) {
        model.addAttribute("name", name);
        return "hello";
    }

}
