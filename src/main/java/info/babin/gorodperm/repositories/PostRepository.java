package info.babin.gorodperm.repositories;

import info.babin.gorodperm.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    List<Post> findAllByOrderByIdDesc();
}
