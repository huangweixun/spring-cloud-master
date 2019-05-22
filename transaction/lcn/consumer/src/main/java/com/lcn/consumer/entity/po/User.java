package com.lcn.consumer.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import com.cloud.core.entity.po.BasePo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_user")
public class User extends BasePo {
    private String username;
    private String password;
    private Boolean enabled;
    private String email;
}
