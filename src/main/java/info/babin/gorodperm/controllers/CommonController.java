package info.babin.gorodperm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping("/about")
    public String about(Model model) {
        return "about";
    }
}
