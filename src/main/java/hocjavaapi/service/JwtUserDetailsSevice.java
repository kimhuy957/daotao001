package hocjavaapi.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class JwtUserDetailsSevice implements UserDetailsService {
    private static final String USER_NAME = "apps";
    // pas nay da ma hoa theo thuat toan Bcrypt:  password
    private static final String PASSWORD = "dG9ZdJbrFRp5pKoOcPLvRPPUXxbuDQXJL9PSPlSnz0hDM1tszXw7v6B0YcKWYspE";

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        if (USER_NAME.equals(s)){
            return new User(USER_NAME, PASSWORD, new ArrayList<>());
        }

        throw new UsernameNotFoundException(s);
    }
}
