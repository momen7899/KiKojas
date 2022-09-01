package com.momen.kikojast.image;

import com.momen.kikojast.common.BaseEntity;
import com.momen.kikojast.place.Place;
import com.momen.kikojast.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_like")
@Data
@Audited
public class Image extends BaseEntity {

    @NotNull
    @Column(name = "image")
    private String image;


    @OneToOne
    @JoinColumn(name = "user_id",unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

}
