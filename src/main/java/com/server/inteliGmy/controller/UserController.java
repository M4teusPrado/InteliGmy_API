package com.server.inteliGmy.controller;


import com.server.inteliGmy.DTOs.BaseUserDTO;
import com.server.inteliGmy.service.UserService;
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
    private UserService userService;

    @GetMapping("/{uid}")
    public ResponseEntity<BaseUserDTO> getUserById(@PathVariable String uid) {
        BaseUserDTO dto = userService.findBaseUserByUid(uid);
        return ResponseEntity.ok().body(dto);
    }
}
