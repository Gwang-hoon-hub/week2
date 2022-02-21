package com.pang.week2.service;

import com.pang.week2.Model.Post;
import com.pang.week2.dtoClass.PostDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PostService {

    @Transactional
    public List<PostDto.resAllPostsDto> getAll(PostDto.reqAllPostDto dto){
        // UserDatailService에서 Member 정보를 가져와야 db에 넣을 수 있음.
        Post post = new Post();

        return ;
    }

}
