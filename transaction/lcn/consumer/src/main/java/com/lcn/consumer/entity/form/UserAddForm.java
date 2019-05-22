package com.lcn.consumer.entity.form;

import com.cloud.core.entity.form.BaseForm;
import com.lcn.consumer.entity.po.User;
import lombok.Data;

@Data
public class UserAddForm extends BaseForm<User> {
    private String email;
    private String username;
    private String password;
    private Boolean enabled;
}
