package com.springbootex.cgjw.spring.web;

import com.springbootex.cgjw.spring.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*JSON을 반환하는 컨트롤러로 만듦*/
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String Hello(){
        return "Hello!";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,@RequestParam("amount") int amount){
        return new HelloResponseDto(name,amount);
    }
}
