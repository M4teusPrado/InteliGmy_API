package com.server.inteliGmy.service;

import com.server.inteliGmy.DTOs.BaseUserDTO;
import com.server.inteliGmy.model.BaseUser;
import com.server.inteliGmy.model.LogUsuario;
import com.server.inteliGmy.repository.LogRepository;
import com.server.inteliGmy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogRepository logRepository;

    public BaseUserDTO findBaseUserByUid(String uid) {
        BaseUser baseUser = userRepository.findBaseUserDTOByUid(uid);
        registrarUsuarioEmLog(baseUser);
        return criarBaseUserDTO(baseUser);
    }

    public BaseUserDTO criarBaseUserDTO(BaseUser baseUser) {
        BaseUserDTO baseUserDTO = new BaseUserDTO();
        baseUserDTO.setUid(baseUser.getUid());
        baseUserDTO.setNivel(baseUser.getNivel());
        return baseUserDTO;
    }

    public void registrarUsuarioEmLog(BaseUser baseUser) {
        LogUsuario log = new LogUsuario(baseUser);
        logRepository.save(log);
    }
}