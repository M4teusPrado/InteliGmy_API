package com.server.inteliGmy.controller;


import com.server.inteliGmy.DTOs.BaseUserDTO;
import com.server.inteliGmy.model.Enuns.Nivel;
import com.server.inteliGmy.repository.UserRepository;
import jakarta.persistence.Tuple;
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
    public ResponseEntity<BaseUserDTO> getUserById(@PathVariable String uid) {

        Tuple result = userRepository.findBaseUserDTOByUid(uid);
        BaseUserDTO baseUserDTO = new BaseUserDTO();
        baseUserDTO.setUid(result.get("uid", String.class));
        baseUserDTO.setNivel(result.get("nivel", Nivel.class));

        return ResponseEntity.ok().body(baseUserDTO);
    }


}
