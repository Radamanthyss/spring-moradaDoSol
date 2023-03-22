package com.brunob.api.spreact.Service;

import com.brunob.api.spreact.Dto.UserDto;
import com.brunob.api.spreact.Dto.Response.ResponseDto;
import org.springframework.http.ResponseEntity;

public interface UserPattern {

    ResponseEntity<?> insertOrUpdate(UserDto userDto, Integer action);

    Iterable<UserDto> getUsers();

    ResponseEntity<ResponseDto> delete(Long id);

    ResponseEntity<?> getUser(Long id);
}
