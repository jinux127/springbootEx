package com.springbootex.cgjw.spring.domain.posts;

import com.springbootex.cgjw.spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
/*테이블과 링크될 클래스임을 나타냄 ex) SalesManager.java -> sales_manager table*/
@Entity //JPA 어노테이션
public class Posts extends BaseTimeEntity {
    @Id // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙, 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야 auto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 나타냄, 굳이 선언하지 않아도 클래스의 필드는 모두 칼럼이 됨.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title,String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
