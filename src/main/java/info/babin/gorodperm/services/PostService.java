package info.babin.gorodperm.services;

import info.babin.gorodperm.models.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    List<Post> getAllPosts();
    Optional<Post> findById(long id);
    Post save(Post post);
    void deleteById(long id);
}
