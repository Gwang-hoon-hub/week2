package com.pang.week2.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Likes extends Timestamped{

    @Id
    @Column(name = "likeId")
    private Long id;

    @Column
    private Boolean like_check;

    @ManyToOne
    @JoinColumn(name = "postId")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;
}
