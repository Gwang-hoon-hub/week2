package com.pang.week2.Model;

import com.pang.week2.dtoClass.PostDto;
import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

    @Column(nullable = false)
    private String img_url;


    @ManyToOne
    @JoinColumn(name = "memberId")
    private Member member;

    public Post(PostDto.reqCreateDto dto, Member member){
        this.img_url = dto.getImg_url();
        this.contents = dto.getContents();
        this.member = member;
    }

    public PostDto update(PostDto.reqUpdateDto dto){
        this.img_url = dto.getImg_url();
        this.contents = dto.getContents();
        return PostDto.builder()
                .contents(this.contents)
                .img_url(this.img_url)
                .id(this.id)
                .member(this.member)
                .build();
    }




}
