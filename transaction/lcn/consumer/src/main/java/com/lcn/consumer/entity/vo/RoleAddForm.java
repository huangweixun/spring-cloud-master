package com.lcn.consumer.entity.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RoleAddForm{
    private String code;
    private String name;
    private String description;
}
