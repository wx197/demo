package com.example.demo.entity.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("sec_user")
public class UserDTO {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String sex;

    private String email;

    private String isDelete;

    private String idCard;

}
