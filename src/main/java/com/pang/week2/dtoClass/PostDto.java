package com.pang.week2.dtoClass;

import lombok.Getter;


public class PostDto {

    public static class resAllPostsDto{
        // 홈 화면에 전체 게시글 정보 보여주기 dto
        private Long post_id;
        private String name;
        private String contents;
        private String img_url;
        private String title;
        private int like_cnt;
        private String create_date;
        private String modified_date;
        private boolean like_ok;
    }

    public static class reqAllPostDto{
        private String title;
        private String img_url;
        private String contents;
    }
}
