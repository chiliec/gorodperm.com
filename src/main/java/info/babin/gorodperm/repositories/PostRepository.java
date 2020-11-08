package info.babin.gorodperm.repositories;

import info.babin.gorodperm.models.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

@Repository
@PreAuthorize("hasRole('USER')")
public interface PostRepository extends PagingAndSortingRepository<Post, Long> {

    @PreAuthorize("hasRole('USER')")
    @Override
    <S extends Post> S save(S s);

    @PreAuthorize("hasRole('USER')")
    @Override
    void delete(Post post);
}
