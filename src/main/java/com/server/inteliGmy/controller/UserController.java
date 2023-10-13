package com.server.inteliGmy.controller;


import com.server.inteliGmy.model.BaseUser;
import com.server.inteliGmy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{uid}")
    public ResponseEntity<BaseUser> getUserById(@PathVariable String uid) {
        return ResponseEntity.ok().body(userRepository.findByUid(uid));
    }


}
