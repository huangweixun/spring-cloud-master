package com.cloud.authorizationserver.entity;

import com.cloud.core.entity.po.BasePo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
