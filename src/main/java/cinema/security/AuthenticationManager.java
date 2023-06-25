package cinema.security;

import cinema.model.User;
import org.springframework.security.core.token.Token;

public interface AuthenticationManager {
    public User authenticate(Token token);
}
