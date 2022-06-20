package in.greyw.expensetrackerapi.Service;

import in.greyw.expensetrackerapi.Entity.User;
import in.greyw.expensetrackerapi.Entity.UserModel;

public interface UserService {

    User createUser(UserModel user);

    User readUser(Long id);

    User updateUser(UserModel user, Long id);

    void deleteUser(Long id);

    User getLoggedInUser();
}
