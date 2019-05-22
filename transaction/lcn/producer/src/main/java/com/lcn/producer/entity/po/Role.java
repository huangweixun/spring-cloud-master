package com.lcn.producer.entity.po;

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
@TableName("t_role")
public class Role extends BasePo {
    private String code;
    private String name;
    private String description;
}
