package com.pang.week2.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "Post")
public class Post extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "postId")
    private Long id;

    @Lob
    @Column(nullable = false)
    private String contents;

    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

}
