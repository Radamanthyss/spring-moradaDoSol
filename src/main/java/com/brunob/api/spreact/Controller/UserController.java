package com.brunob.api.spreact.Controller;

import com.brunob.api.spreact.Dto.UserDto;
import com.brunob.api.spreact.Dto.Response.ResponseDto;
import com.brunob.api.spreact.Service.Impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping(value = "/login")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService produtoService;

    @GetMapping
    public Iterable<UserDto> getProdutos(){
        return produtoService.getUsers();
    }

    @GetMapping("/{email}/{password}")
    public ResponseEntity<?> getProduto(@PathVariable Long id){
        return produtoService.getUser(id);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserDto userDto){
        return produtoService.insertOrUpdate(userDto,0);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDto userDto){
        return produtoService.insertOrUpdate(userDto,1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto> delete(@PathVariable Long id){
        return produtoService.delete(id);
    }
}
