package com.springbootex.cgjw.spring;

import com.springbootex.cgjw.spring.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*스프링부트 테스트와 JUnit사이의 연결자 역할
* JUnit 내장된 실행자 외에 SpringRunner라는 스프링 실행자 사용 */
@RunWith(SpringRunner.class)
/*@Controller,@ControllerAdvice 등을 사용할 수 있다.
* 단, @Service, @Component, @Repository 등은 사용 불가*/
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    /*스프링이 관리하는 빈 주입*/
    @Autowired
    /*웹 API 테스트 할때 사용*/
    private MockMvc mvc;

    @Test
    public void return_hello() throws Exception{
        String hello = "Hello!";
//        /hello 주소로 HTTP GET 요청
        mvc.perform(get("/hello"))
//                HTTP Header의 상태 검증 , 여기서는 200인지 아닌지
                .andExpect(status().isOk())
//                Controller에서 리턴하는 값이 "Hello"인지 검증
                .andExpect(content().string(hello));
    }
}
