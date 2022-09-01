package com.momen.kikojast.like;


import com.momen.kikojast.comment.Comment;
import com.momen.kikojast.common.BaseEntity;
import com.momen.kikojast.place.Place;
import com.momen.kikojast.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_like")
@Data
@Audited
public class Like extends BaseEntity {

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    private LikeType type;
}
