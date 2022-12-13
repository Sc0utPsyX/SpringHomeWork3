package ru.gb.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("/v1")
public class HelloBodyController {

    // Client -> [tomcat server] -> DispatcherServlet -> HelloController

    // DispatcherServlet

    // http://localhost:8180/app/v1/hello?name=Igor
    // address header params
    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return "<h1>Hello, " + name + "!</h1>";
    }

    @GetMapping("/home")
    public String home() {
        return "Home page";
    }

}
