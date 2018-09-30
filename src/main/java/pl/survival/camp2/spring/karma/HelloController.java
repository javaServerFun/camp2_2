package pl.survival.camp2.spring.karma;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello. time is: " + LocalDateTime.now();
    }
}
