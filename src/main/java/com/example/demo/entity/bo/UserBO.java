package com.example.demo.entity.bo;

import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class UserBO {

    @NotNull
    private String userName;

    @NotNull
    private String sex;

    @NotNull
    private String email;

    @NotNull
    private String idCard;

}
