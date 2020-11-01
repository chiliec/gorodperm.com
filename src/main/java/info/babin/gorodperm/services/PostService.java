package info.babin.gorodperm.services;

import info.babin.gorodperm.models.Post;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface PostService {
    Page<Post> getPostsByPage(int page);
    Optional<Post> findById(long id);
    Post save(Post post);
    void deleteById(long id);
}
