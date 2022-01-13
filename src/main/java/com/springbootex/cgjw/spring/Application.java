package com.springbootex.cgjw.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/*스프링 부트의 자동 설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
* 이 위치부터 설정을 읽어감
* 항상 프로젝트의 최상단 위치*/
// @EnableJpaAuditing 삭제
// @EnableJpaAuditing // JPA Auditing 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
//        내장 WAS 실행 >> 톰캣 설치 x, 스프링 부트로 만들어진 Jar 파일로 실행
        SpringApplication.run(Application.class, args);
    }
}
