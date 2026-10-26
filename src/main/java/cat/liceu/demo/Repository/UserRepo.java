package cat.liceu.demo.Repository;

import cat.liceu.demo.Models.User;

public interface UserRepo {
    User findByUserName(String username);
}
