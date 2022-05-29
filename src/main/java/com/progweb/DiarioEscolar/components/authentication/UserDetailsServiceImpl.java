package com.progweb.DiarioEscolar.components.authentication;

import java.util.Collections;

import com.progweb.DiarioEscolar.domain.User;
import com.progweb.DiarioEscolar.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
//fazer a busca do usuario no banco de dados

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username + "nao encontrado no banco de dados");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getAuthority(), Collections.emptyList());
    }
    
}
