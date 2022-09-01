package com.momen.kikojast.user;


import com.momen.kikojast.common.BaseDTO;
import com.momen.kikojast.common.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
public class UserDTO extends BaseDTO {
    @ApiModelProperty(required = true, hidden = false)
    private String name;
    @ApiModelProperty(required = true, hidden = false)
    private String email;
    @ApiModelProperty(required = true, hidden = false)
    private String password;
}
