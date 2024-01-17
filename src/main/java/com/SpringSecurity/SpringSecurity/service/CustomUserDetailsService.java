package com.SpringSecurity.SpringSecurity.service;

import com.SpringSecurity.SpringSecurity.dto.CustomUserDetails;
import com.SpringSecurity.SpringSecurity.entity.UserEntity;
import com.SpringSecurity.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity userEntity = userRepository.findUserEntityByUsername(username);

        if(userEntity != null) {
            return new CustomUserDetails(userEntity);
        }

        return null;
    }
}
