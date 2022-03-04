package tj.kmg.blog.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tj.kmg.blog.test.domain.Posts;

public interface PostsRepository extends JpaRepository<Posts, Long> {
}