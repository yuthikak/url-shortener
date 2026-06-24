package com.example.UrlShortener.Controller;
import com.example.UrlShortener.Entity.UserEntry;
import com.example.UrlShortener.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserContoller {

@Autowired
private UserService userService;

@PostMapping
    public void createUser(@RequestBody UserEntry userEntry)
{
    userService.saveUser(userEntry);

}

}
