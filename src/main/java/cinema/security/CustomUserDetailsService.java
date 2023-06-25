package cinema.security;

import static org.springframework.security.core.userdetails.User.withUsername;

import cinema.model.User;
import cinema.service.UserService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByEmail(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            org.springframework.security.core.userdetails.User.UserBuilder
                    builder = withUsername(username);
            return builder.password(user.getPassword())
                    .roles(user.getRoles().stream()
                            .map(r -> r.getRoleName().name())
                            .toArray(String[]::new)).build();
        }
        throw new UsernameNotFoundException("User " + username + " not found");
    }
}
