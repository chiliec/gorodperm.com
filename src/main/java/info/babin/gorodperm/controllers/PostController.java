package info.babin.gorodperm.controllers;

import info.babin.gorodperm.models.Post;
import info.babin.gorodperm.services.PostService;
import info.babin.gorodperm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String list() {
        return "post/list";
    }

    @GetMapping("/new")
    public String create(Model model) {
//        model.addAttribute("title", "Заголовок");
//        model.addAttribute("content", "Контент");
        return "post/create";
    }

    @RequestMapping(value="/create", method=RequestMethod.POST)
    @ResponseBody
    public Post create(@RequestParam("title") String title,
                       @RequestParam("content") String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        return postService.save(post);
    }
}
