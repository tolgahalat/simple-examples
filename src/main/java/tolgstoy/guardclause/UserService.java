package tolgstoy.guardclause;

public class UserService {
    public void registerUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getName() == null || user.getName().isEmpty()) {
            throw new IllegalArgumentException("User name cannot be empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new IllegalArgumentException("User email cannot be empty");
        }
        // Proceed with registration
        System.out.println("Registering user: " + user.getName());
    }
}
