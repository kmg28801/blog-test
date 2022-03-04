package tj.kmg.blog.test.config.auth.dto;


import lombok.Getter;
import tj.kmg.blog.test.domain.User;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
   private String name;
   private String email;
   private String picture;

   public SessionUser(User user) {
       this.name = user.getName();
       this.email = user.getEmail();
       this.picture = user.getPicture();
   }
}