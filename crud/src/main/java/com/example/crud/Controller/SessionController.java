package com.example.crud.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SessionController {

    @GetMapping("/setSession")
    public String setSession(HttpSession session) {
        session.setAttribute("username", "JinhyeongPark");
        return "세션 속성 'username'가 성공적으로 설정되었습니다.";
    }

    @GetMapping("/getSession")
    public String getSession(HttpSession session) {
        String username = (String)session.getAttribute("username");
        if (username == null) {
            return "세션 속성 'username'이 설정되지 않았습니다.";
        } else {
            return "세션 속성 'username' 값: " + username;
        }
    }

}
