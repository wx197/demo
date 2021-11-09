package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.BaseException;
import com.example.demo.common.StatusCodeEnum;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.bo.UserBO;
import com.example.demo.entity.dto.UserDTO;
import com.example.demo.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor =Exception.class)
    public void insert(UserBO userBO){
        QueryWrapper<UserDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserDTO::getIdCard, userBO.getIdCard());
        UserDTO selectOne = userMapper.selectOne(queryWrapper);
        if(selectOne != null){
            throw new BaseException(StatusCodeEnum.SUCCESS,"人员已存在");
        }
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(userBO,userDTO);
        userDTO.setIsDelete("1");
        userMapper.insert(userDTO);
    }

    @Override
    public UserDTO getUserById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public List<UserDTO> list() {
        QueryWrapper<UserDTO> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserDTO::getIsDelete,0);
        return  userMapper.selectList(queryWrapper);
    }
}
