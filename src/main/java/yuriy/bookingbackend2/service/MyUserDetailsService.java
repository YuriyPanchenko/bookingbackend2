package yuriy.bookingbackend2.service;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yuriy.bookingbackend2.models.User;
import yuriy.bookingbackend2.principals.UserPrincipal;
import yuriy.bookingbackend2.repository.UserRepository;

@Primary
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByLogin(s);
        if (user==null)
            throw new UsernameNotFoundException("user not found");
        return new UserPrincipal(user);
    }
}
