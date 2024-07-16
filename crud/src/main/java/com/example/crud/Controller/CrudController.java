package com.example.crud.Controller;

import com.example.crud.Entity.Post;
import com.example.crud.Service.CrudService;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/posts")
public class CrudController {

    @Autowired
    private CrudService crudService;

    @Operation(summary="게시물 조회", description="전체 게시물을 조회합니다.")
    @GetMapping
    public List<Post> getAllPosts() {
        return crudService.getAllPosts();
    }

    @Operation(summary="게시물 조회", description="ID를 통해 게시물을 조회합니다.")
    @GetMapping("/getPostById/{id}")
    public Post getPostById(@PathVariable Long id) {
        return crudService.getPostById(id);
    }

    @Operation(summary="게시물 생성", description="게시물을 생성합니다.")
    @PostMapping
    public void creatPost(@RequestBody Post post) {
        crudService.createPost(post);
    }

    @Operation(summary="게시물 수정", description="게시물을 수정합니다.")
    @PutMapping("/{id}")
    public void updatePost(@PathVariable Long id, @RequestBody Post post) {
        crudService.updatePost(id, post);
    }
    @Operation(summary="게시물 삭제", description="게시물을 삭제합니다.")
    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id) {
        crudService.deletePost(id);
    }

    //제목을 통해 게시물 조회하기
    @Operation(summary="게시물 조회", description="제목을 통해 게시물을 조회합니다.")
    @GetMapping("/getPostByTitle/{searchKeyword}")
    public List<Post> getPostByTitle(@PathVariable String searchKeyword) {
        return crudService.getPostByTitle(searchKeyword);
    }

    //제시자 이름을 통해 게시물 조회하기
    @Operation(summary="게시물 조회", description="게시자 이름을 통해 게시물을 조회합니다.")
    @GetMapping("/getPostByName/{name}")
    public List<Post> getPostByName(@PathVariable String name) {
        return crudService.getPostByName(name);
    }


}
