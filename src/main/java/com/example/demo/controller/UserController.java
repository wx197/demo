package com.example.demo.controller;

import com.example.demo.common.ApiResponse;
import com.example.demo.entity.bo.UserBO;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("getUserById")
    public ApiResponse<Object> getUserById(@RequestParam(value = "id") Long id){
        UserDTO userById = userService.getUserById(id);
        return ApiResponse.ofSuccess(userById);
    }

    @PostMapping("insert")
    public ApiResponse insert(@RequestBody UserBO userBO){
        userService.insert(userBO);
        return ApiResponse.ofSuccess();
    }

    @GetMapping("list")
    public ApiResponse list(){
        return ApiResponse.ofSuccess(userService.list());
    }
}