package com.springbootex.cgjw.spring.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    /*스프링 시큐리티에는권한 코드에 항상 ROLE_ 이 앞에 있어야함*/
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String Key;
    private final String title;
}
