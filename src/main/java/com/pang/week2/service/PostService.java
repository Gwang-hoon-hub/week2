package com.pang.week2.service;

import com.pang.week2.Model.Post;
import com.pang.week2.common.error.exception.NotFoundException;
import com.pang.week2.dtoClass.PostDto;
import com.pang.week2.repository.LikeRepository;
import com.pang.week2.repository.PostRepository;
import com.pang.week2.security.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
//    private final UserDetailsImpl userDetails;
    
    // 조회 : 전체 게시글 보여주기
    @Transactional(readOnly = true)
    public List<PostDto.resAllPostsDto> getAll(UserDetailsImpl userDetails){
        // UserDatailService에서 Member 정보를 가져와야 db에 넣을 수 있음.
//        Post post = new Post(userDetails.getMember());
        if(userDetails == null){
            // 로그인하지 않은 사용자 게시물 보여주기
            List<Post> postList = postRepository.findAll();


        } else {
            // 로그인 되어있는 사용자 게시물 보여주기 ==> 좋아요 체크해두기

        }
        return ;
    }

    // 생성
    @Transactional
    public PostDto createPost(PostDto.reqCreateDto dto, UserDetailsImpl userDetails){
        Post post = new Post(dto, userDetails.getMember());
        Post saved = postRepository.save(post);
        // saved를 보내는 이유
        // 1. 엔터티는 리턴값으로 보내지 않는다.
        // 2. of 메소드를 이용하여 postDto로 만들어 보내준다.
        // 3. 저장된 값은 pk인 id가 자동 증가한 값을 갖고 잇다.
        return PostDto.of(saved);
    }

    // 수정
    @Transactional
    public PostDto updatePost(Long postId, PostDto.reqUpdateDto dto){
        Optional<Post> byId = postRepository.findById(postId);
        if(byId.isEmpty()){
            throw new NotFoundException("없는 게시글.");
        }
        Post post = byId.get();
        PostDto updated = post.update(dto);
        return updated;
    }

    // 삭제
    @Transactional
    public void deletePost(Long postId){
        Optional<Post> byId = postRepository.findById(postId);
        if(byId.isEmpty()){
            throw new NotFoundException("없는 게시글.");
        } else{
            postRepository.deleteById(postId);
        }
    }
}
