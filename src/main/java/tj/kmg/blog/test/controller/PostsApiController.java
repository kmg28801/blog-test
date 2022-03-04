package tj.kmg.blog.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import tj.kmg.blog.test.service.PostService;
import tj.kmg.blog.test.web.dto.PostsResponseDto;
import tj.kmg.blog.test.web.dto.PostsSaveRequestDto;
import tj.kmg.blog.test.web.dto.PostsUpdateRequestDto;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

   private final PostService postService;

   @PostMapping("/api/v1/posts")
   public Long save(@RequestBody PostsSaveRequestDto requestDto) {

       return postService.save(requestDto);
   }
   
   @PutMapping("/api/v1/posts/{id}")
   public Long update(@PathVariable Long id, @RequestBody 
		   PostsUpdateRequestDto requestDto) {

       return postService.update(id, requestDto);
   }

   @GetMapping("/api/v1/posts/{id}")
   public PostsResponseDto findById (@PathVariable Long id) {

       return postService.findById(id);
   }
   
}