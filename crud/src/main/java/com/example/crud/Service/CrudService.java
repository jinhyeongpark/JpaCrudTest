package com.example.crud.Service;

import com.example.crud.Entity.Post;
import com.example.crud.Repository.CrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CrudService {

    @Autowired
    private CrudRepository crudRepository;


    public List<Post> getAllPosts() {
        return crudRepository.findAll();
    }

    public void createPost(Post post) {
        crudRepository.save(post);
    }
    public Post getPostById(Long id) {
        Optional<Post> post = crudRepository.findById(id);
        if (post.isEmpty()) {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다");
        }
        return post.get();
    }

    public void updatePost(Long id, Post post) {
        Optional<Post> postTemp = crudRepository.findById(id);
        if (postTemp.isPresent()) {
            Post existingPost = postTemp.get();
            existingPost.setTitle(post.getTitle());
            existingPost.setContent(post.getContent());

            crudRepository.save(existingPost);
        } else {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다");
        }
    }

    public void deletePost(Long id) {
        if (crudRepository.existsById(id)) {
            crudRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("게시글이 존재하지 않습니다");
        }
    }

    public List<Post> getPostByTitle(String searchKeyword) {
        return crudRepository.findByTitleContaining(searchKeyword);
    }


    public List<Post> getPostByName(String name) {
        return crudRepository.findByName(name);
    }
}
