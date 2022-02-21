package com.pang.week2.controller;

import com.pang.week2.dtoClass.PostDto;
import com.pang.week2.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @GetMapping("/api/posts")
    public ResponseEntity<List<PostDto.resAllPostsDto>> getAllPosts(@RequestBody PostDto.reqAllPostDto dto){
        List<PostDto.resAllPostsDto> response = postService.getAll(dto);
        return ResponseEntity.ok(response);
    }
}

