package com.pang.week2.controller;

import com.pang.week2.dtoClass.PostDto;
import com.pang.week2.security.UserDetailsImpl;
import com.pang.week2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    // 조회 : 전체 게시글 조회하기
    @GetMapping("/api/posts")
    public ResponseEntity<List<PostDto.resAllPostsDto>> getAllPosts(
             @AuthenticationPrincipal UserDetailsImpl userDetails){
        List<PostDto.resAllPostsDto> response = postService.getAll(userDetails);
        return ResponseEntity.ok(response);
    }

    // 생성
    // 들어오는 값 : contents, img_url,
    @PostMapping("api/posts")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto.reqCreateDto dto,
            @AuthenticationPrincipal UserDetailsImpl userDetails){
        PostDto postDto = postService.createPost(dto, userDetails);
        return ResponseEntity.ok(postDto);
    }

    // 수정
    @PatchMapping("api/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(
            @PathVariable("postId") Long postId,
            @RequestBody PostDto.reqUpdateDto dto){
        PostDto response = postService.updatePost(postId, dto);

        return ResponseEntity.ok(response);
    }

    // 삭제
    @DeleteMapping("api/posts/{postId}")
    public ResponseEntity deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}

