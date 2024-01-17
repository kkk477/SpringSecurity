package com.SpringSecurity.SpringSecurity.service;

import com.SpringSecurity.SpringSecurity.dto.JoinDto;
import com.SpringSecurity.SpringSecurity.entity.UserEntity;
import com.SpringSecurity.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void joinProcess(JoinDto joinDto) {

        if(userRepository.existsUserEntityByUsername(joinDto.getUsername())){
            return;
        }

        UserEntity user = new UserEntity();
        user.setUsername(joinDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(joinDto.getPassword()));
        user.setRole("ROLE_ADMIN");

        userRepository.save(user);
    }
}
