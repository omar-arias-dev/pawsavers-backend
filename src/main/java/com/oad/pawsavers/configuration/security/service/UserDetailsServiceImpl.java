package com.oad.pawsavers.configuration.security.service;

import com.oad.pawsavers.configuration.security.administrator.Administrator;
import com.oad.pawsavers.configuration.security.administrator.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + "not exists."));

        Collection<? extends GrantedAuthority> grantedAuthorities = administrator.getRoleSet()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName().name())))
                .collect(Collectors.toSet());

        return new User(
                administrator.getUsername(),
                administrator.getPassword(),
                true,
                true,
                true,
                true,
                grantedAuthorities
        );
    }
}
