package com.atguigu.servicebase.exceptionhandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 生成有参数的构造方法
@NoArgsConstructor  // 生成无参数的构造方法
public class CustomException extends RuntimeException{

    private Integer code;
    private String msg;


}
