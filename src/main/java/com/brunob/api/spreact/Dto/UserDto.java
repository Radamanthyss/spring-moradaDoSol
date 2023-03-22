package com.brunob.api.spreact.Dto;

import lombok.Data;

@Data
public class UserDto {

    public Long id;
    public String nome;
    public String email;
    public String password;
    public Integer level;
}
