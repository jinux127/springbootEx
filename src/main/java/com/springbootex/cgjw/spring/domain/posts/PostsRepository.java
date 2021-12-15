package com.springbootex.cgjw.spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//보통 Mybatis 에서 Dao라고 불리는 DB Layer 접근자, JPA에선 Repository 라고 부름
/*Entity클래스와 기본 Entity Repository는 함께 위치해야함*/
public interface PostsRepository extends JpaRepository<Posts,Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
