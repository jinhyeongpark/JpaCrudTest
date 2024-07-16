package com.example.crud.Repository;

import com.example.crud.Entity.Post;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitleContaining(String searchKeyword);

    List<Post> findByName(String name);
}
