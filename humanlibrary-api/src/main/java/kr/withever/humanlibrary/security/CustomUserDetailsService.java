package kr.withever.humanlibrary.security;

import kr.withever.humanlibrary.domain.user.User;
import kr.withever.humanlibrary.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by youngjinkim on 2017. 2. 14..
 */

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService() {}

    @Override
    public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
        User user = this.userRepository.retrieveUserByLoginId(loginId);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", loginId));
        }
        return new LoginUser(user.getLoginId(), user.getPassword(), user.getRoles());
    }
}
