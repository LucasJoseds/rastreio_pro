package com.lucas.rastreio.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.rastreio.domain.dto.UserDTO;
import com.lucas.rastreio.domain.model.User;
import com.lucas.rastreio.service.UserService;

@RestController
@RequestMapping(value="/user")
public class UserController {
    
    @Autowired
    UserService userService;

    @PostMapping(value="/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto){

        User nUser = userService.create(dto);
        return new ResponseEntity<User>(nUser, HttpStatus.CREATED);

    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<User> updadteUser(@PathVariable Long id , @RequestBody UserDTO dto) throws Exception{

        User nUser = userService.update(id, dto);
        return new ResponseEntity<User>(nUser, HttpStatus.CREATED);

    }
}
