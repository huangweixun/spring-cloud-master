package com.lcn.consumer.entity.param;

import lombok.Data;

@Data
public class UserAddParam {
    private String name;
    private String mobile;
    private String username;
    private String password;
    private Boolean enabled;
}
