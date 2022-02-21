package com.pang.week2.dtoClass;

import com.pang.week2.Model.Member;
import com.pang.week2.Model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
public class PostDto {

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

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class resAllPostsDto{
        // 홈 화면에 전체 게시글 정보 보여주기 dto
        private Long post_id;       // 게시글 번호
        private String name;        // 게시자 이름
        private String contents;    // 내용
        private String img_url;     // 이미지 url
        private int like_cnt;       // 좋아요 수
        private String create_date; // 생성 날짜
        private String modified_date;   // 수정 날짜
        private boolean like_ok;    // 좋아요 유무
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class reqCreateDto{
        // 게시글 작성 시 들어오는 데이터
        @Lob
        @NotNull
        private String img_url;

        @NotNull
        private String contents;
    }

    @Getter
    @Builder
    @AllArgsConstructor
    public static class reqUpdateDto{
        @Lob
        @NotNull
        private String img_url;

        @NotNull
        private String contents;
    }

    static public PostDto of(Post post){
        return PostDto.builder()
                .id(post.getId())
                .contents(post.getContents())
                .img_url(post.getImg_url())
                .member(post.getMember())
                .build();
    }
}
