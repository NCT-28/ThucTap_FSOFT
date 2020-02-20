package login.facebook.security;

import java.util.Collections;
import java.util.Optional;

import login.facebook.persistence.dao.UserRepository;
import login.facebook.persistence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public MyUserDetailsService() {
        super();
    }

    // API

    @Override
    public UserDetails loadUserByUsername(final String username) {
        Optional<User> optional = userRepository.findByUsername(username);
        User user = optional.orElseThrow(() -> new UsernameNotFoundException(username));
        return new org.springframework.security.core.userdetails.User(username, user.getPassword(), true, true, true, true, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
