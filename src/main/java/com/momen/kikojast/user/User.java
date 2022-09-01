package com.momen.kikojast.user;


import com.momen.kikojast.common.BaseEntity;
import com.momen.kikojast.image.Image;
import com.momen.kikojast.like.Like;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_user")
@Data
@Audited
public class User extends BaseEntity {
    @NotNull
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String password;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToOne
    private Image image;
}
