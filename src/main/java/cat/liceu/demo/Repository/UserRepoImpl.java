package cat.liceu.demo.Repository;

import cat.liceu.demo.Models.User;
import org.springframework.stereotype.Component;

@Component
public class UserRepoImpl implements UserRepo{
    @Override
    public User findByUserName(String username) {
       if(username.equals("bill")){
    return  new User("bill","1234");
       }else
           return  new User("bilfl","12348");
    }
}
