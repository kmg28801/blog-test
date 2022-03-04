package tj.kmg.blog.test.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import tj.kmg.blog.test.domain.Posts;
import tj.kmg.blog.test.repository.PostsRepository;
import tj.kmg.blog.test.web.dto.PostsResponseDto;
import tj.kmg.blog.test.web.dto.PostsSaveRequestDto;
import tj.kmg.blog.test.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@Service
public class PostService {
   private final PostsRepository postsRepository;

   @Transactional
   public Long save(PostsSaveRequestDto requestDto) {
       return postsRepository.save(requestDto.toEntity()).getId();
   }
   
   @Transactional
   public Long update(Long id, PostsUpdateRequestDto requestDto) {
       Posts posts = postsRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

       posts.update(requestDto.getTitle(), requestDto.getContent());
       return id;
   }
   
   public PostsResponseDto findById (Long id) {
       Posts entity = postsRepository.findById(id)
               .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

       return new PostsResponseDto(entity);
   }
}