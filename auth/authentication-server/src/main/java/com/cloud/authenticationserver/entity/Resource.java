package com.cloud.authenticationserver.entity;

import com.cloud.core.entity.po.BasePo;
import lombok.Data;

@Data
public class Resource extends BasePo {
    private String code;
    private String name;
    private String type;
    private String url;
    private String method;
    private String description;
}
