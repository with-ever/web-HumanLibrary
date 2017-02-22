package kr.withever.humanlibrary.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by youngjinkim on 2017. 2. 14..
 */
public class LoginUser implements UserDetails {

    public static LoginUser getLoginUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.getPrincipal() instanceof LoginUser) {
            LoginUser loginUser = (LoginUser) authentication.getPrincipal();
            return loginUser;
        }
        return null;
    }

    public static Set<String> getLoginUserRoles() {
        LoginUser loginUser = getLoginUser();
        if (loginUser != null) return loginUser.getRoles();
        return null;
    }


    /** */
    private String username;
    /** */
    private String password;

    private Set<String> roles;

    private Set<SimpleGrantedAuthority> authorities;

    public LoginUser(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;

        this.authorities = new HashSet<SimpleGrantedAuthority>();
        for (String role : roles) {
            this.authorities.add(new SimpleGrantedAuthority(role));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Set<String> getRoles() {
        return this.roles;
    }

}
