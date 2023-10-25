package com.server.inteliGmy.DTOs;

import com.server.inteliGmy.model.Enuns.Nivel;
import lombok.Data;

@Data
public class BaseUserDTO {

    private String uid;
    private Nivel nivel;
}
