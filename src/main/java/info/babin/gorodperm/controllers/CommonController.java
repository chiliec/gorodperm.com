package info.babin.gorodperm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {

    @GetMapping("/")
    public String home() {
        return "redirect:/posts/";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
