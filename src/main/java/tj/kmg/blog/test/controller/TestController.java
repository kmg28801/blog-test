package tj.kmg.blog.test.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import tj.kmg.blog.test.config.auth.dto.SessionUser;
import tj.kmg.blog.test.domain.Posts;
import tj.kmg.blog.test.repository.PostsRepository;

@RequiredArgsConstructor
@Controller
public class TestController {

	
	private final HttpSession httpSession;
	private final PostsRepository postsRepository;

	
	@GetMapping("/")
	public String index(Model model) {
	    

	    SessionUser user = (SessionUser) httpSession.getAttribute("user");

	    if(user != null){
	        model.addAttribute("userName", user.getName());
	    }

	    return "index";
	}
	
	@GetMapping("/test10")
	public void getArticle() {
		String title = "테스트 게시글";
		String content = "테스트 본문";
		
		this.postsRepository.save(Posts.builder()
										.title(title)
										.content(content)
										.author("kmg08801@gmail.com")
										.build()
										);
		 //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        System.out.println(posts.getTitle());
        System.out.println(posts.getContent());
	}
	
	
}
