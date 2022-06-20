package in.greyw.expensetrackerapi.Service;

import in.greyw.expensetrackerapi.Entity.User;
import in.greyw.expensetrackerapi.Entity.UserModel;

public interface UserService {

    User createUser(UserModel user);

    User readUser();

    User updateUser(UserModel user);

    void deleteUser();

    User getLoggedInUser();
}
