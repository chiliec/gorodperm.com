package info.babin.gorodperm.controllers;

import info.babin.gorodperm.models.Post;
import info.babin.gorodperm.services.PostService;
import info.babin.gorodperm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String list(@RequestParam(value = "p", defaultValue = "1") int pageNumber, Model model) {
        Page<Post> page = postService.getPostsByPage(pageNumber-1);
        model.addAttribute("page", page);
        model.addAttribute("currentDate", new Date());
        return "post/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("post", new Post());
        return "post/edit";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") long id, Model model) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
        }
        return "post/edit";
    }

    @RequestMapping(value="/save", method=RequestMethod.POST)
    public String save(@RequestParam(value = "id", required = false) Long id,
                       @RequestParam("title") String title,
                       @RequestParam("content") String content) {
        Post post = new Post();
        if (id != null) {
            post.setId(id);
        }
        post.setTitle(title);
        post.setContent(content);
        Post savedPost = postService.save(post);
        return "redirect:/posts/"+savedPost.getId();
    }

    @GetMapping("/{id}")
    public String view(@PathVariable long id, Model model) {
        Optional<Post> post = postService.findById(id);
        if (post.isPresent()) {
            model.addAttribute("post", post.get());
            model.addAttribute("currentDate", new Date());
        }
        return "post/view";
    }
}
