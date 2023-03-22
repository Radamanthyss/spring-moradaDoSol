package com.brunob.api.spreact.Service.Impl;

import com.brunob.api.spreact.Dto.UserDto;
import com.brunob.api.spreact.Dto.Response.ResponseDto;
import com.brunob.api.spreact.Entity.User;
import com.brunob.api.spreact.Repository.UserRepository;
import com.brunob.api.spreact.Service.UserPattern;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserPattern {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResponseDto responseDto;

    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<?> insertOrUpdate(UserDto userDto, Integer action){
        try {
            userRepository.save(modelMapper.map(userDto, User.class));
            if (action == 0) {
                return new ResponseEntity<UserDto>(userDto, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<UserDto>(userDto, HttpStatus.OK);
            }
        } catch (Exception e) {
            responseDto.setMensagem("Ocorreu um erro na operação!");
            return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.BAD_REQUEST);
        }

    }

    public Iterable<UserDto> getUsers(){
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserDto>>(){}.getType());
    }

    public ResponseEntity<ResponseDto> delete(Long id) {
        userRepository.deleteById(id);
        responseDto.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
    }

    public ResponseEntity<?> getUser(Long id) {

        Optional<User> retorno = userRepository.findById(id);
        if(retorno.isEmpty()){
            responseDto.setMensagem("Não foi encontrado produto com este ID");
            return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<UserDto>(modelMapper.map(retorno.get(), UserDto.class),HttpStatus.OK);

    }
}
