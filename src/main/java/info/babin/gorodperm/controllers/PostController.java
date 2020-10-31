package info.babin.gorodperm.controllers;

import info.babin.gorodperm.models.Post;
import info.babin.gorodperm.services.PostService;
import info.babin.gorodperm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/")
    public String list(Model model) {
        Collection<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        model.addAttribute("currentDate", new Date());
        return "post/list";
    }

    @GetMapping("/create")
    public String create() {
        return "post/create";
    }

//    @GetMapping("/update")
//    public String create(Model model) {
//        model.addAttribute("id", id)
//        model.addAttribute("title", title);
//        model.addAttribute("content", content);
//        return "post/create";
//    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@RequestParam("title") String title,
                       @RequestParam("content") String content) {
        Post post = new Post();
        post.setTitle(title);
        post.setContent(content);
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable int id, Model model) {
        Optional<Post> post = postService.findById(id);
        model.addAttribute("post", post);
        model.addAttribute("currentDate", new Date());
        return "post/list";
    }
}
