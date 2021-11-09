package com.example.demo.service;

import com.example.demo.entity.bo.UserBO;
import com.example.demo.entity.dto.UserDTO;

import java.util.List;

public interface UserService {

    void insert(UserBO userBO);

    UserDTO getUserById(Long id);

    List<UserDTO> list();
}
