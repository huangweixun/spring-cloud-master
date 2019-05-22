package com.lcn.producer.entity.form;

import com.cloud.core.entity.form.BaseForm;

import com.lcn.producer.entity.po.Role;
import lombok.Data;

@Data
public class RoleAddForm extends BaseForm<Role> {
    private String code;
    private String name;
    private String description;
}
