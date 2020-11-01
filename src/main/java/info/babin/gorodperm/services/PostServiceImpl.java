package info.babin.gorodperm.services;

import info.babin.gorodperm.models.Post;
import info.babin.gorodperm.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private Environment environment;

    @Override
    public Page<Post> getPostsByPage(int page) {
        String sPageSize = environment.getProperty("posts.pageSize") != null
                ? environment.getProperty("posts.pageSize")
                : "10";
        int pageSize = Integer.parseInt(sPageSize);
        Pageable pageable = PageRequest.of(page, pageSize, Sort.Direction.DESC, "id");
        return postRepository.findAll(pageable);
    }

    @Override
    public Optional<Post> findById(long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deleteById(long id) {
        postRepository.deleteById(id);
    }
}
