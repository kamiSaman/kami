
package com.bootserver.context;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@RestController
public class TestController {
 
    @RequestMapping("/hello")
    public String hello() {
        return "Hello Spring Boot!";
    }
 
}