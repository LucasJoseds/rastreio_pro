package com.lucas.rastreio.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.rastreio.domain.dto.UserDTO;
import com.lucas.rastreio.domain.model.User;
import com.lucas.rastreio.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(UserDTO dto) {

        User nUser = new User(dto);
        return userRepository.save(nUser);

    }

    public User update(Long id, UserDTO dto) throws Exception {

        Optional<User> oldUser = userRepository.findById(id);

        if (!oldUser.isPresent()) {
            throw new Exception("Usuário não encontrado na base de dados");
        }
        User nUser = oldUser.get();
        BeanUtils.copyProperties(dto, nUser,"id");;
        return userRepository.save(nUser);

    }

}
