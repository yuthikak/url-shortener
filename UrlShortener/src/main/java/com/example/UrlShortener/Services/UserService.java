package com.example.UrlShortener.Services;

import com.example.UrlShortener.Entity.UserEntry;
import com.example.UrlShortener.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void saveUser(UserEntry userEntry) {
        userRepository.save(userEntry);


    }
}
