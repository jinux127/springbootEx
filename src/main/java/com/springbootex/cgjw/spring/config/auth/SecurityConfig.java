package com.springbootex.cgjw.spring.config.auth;

import com.springbootex.cgjw.spring.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity//Spirng Security 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()// h2-console 화면 사용하기 위해 disable
                .and()
                    .authorizeRequests()// URL별 권한 관리 옵션의 시작점 이 구문이 선언되어야 antMatchers 옵션을 사용할 수 있다.
                    .antMatchers("/","/css/**","/images/**","/js/**","/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name()) //권한 관리 대상 지정, URL, HTTP 메소드 별로 관리 가능
                    .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL, 여기서는 나머지 URL 들은 인증된 사용자만 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/") // 로그아웃 성공시 / 주소 이동
                .and()
                    .oauth2Login()// OAuth 2 로그인 기능 여러 설정의 진입점
                        .userInfoEndpoint()// OAuth 로그인 성공 이후 사용자 정보를 가져올 때의 설정들을 담당
                            .userService(customOAuth2UserService); // 소셜 로그인 성공 시 후속 조치 진행할 UserService 인터페이스 구현체 등록, 리소스 서버에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능 명시할 수 있음
    }
}
