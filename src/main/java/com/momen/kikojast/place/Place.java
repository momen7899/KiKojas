package com.momen.kikojast.place;

import com.momen.kikojast.comment.Comment;
import com.momen.kikojast.common.BaseEntity;
import com.momen.kikojast.image.Image;
import com.momen.kikojast.like.Like;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_place")
@Data
@Audited
public class Place extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "start_service")
    private Integer startService;

    @NotNull
    @Column(name = "end_service")
    private Integer endService;

    @NotNull
    @Column(name = "address")
    private String address;

    @NotNull
    @Column(name = "place_type")
    @Enumerated
    private PlaceType type;

    @Column(name = "place_location")
    private Point<G2D> location;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> like;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Image> images;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;


}
