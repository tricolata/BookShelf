package com.springboot.bookshelfapp.controller;

import com.springboot.bookshelfapp.model.Member;
import com.springboot.bookshelfapp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MemberController {

    private final UserService userService;

    @PostMapping("/user/login")
    public ResponseEntity<Member> login(String userId, String password) {
        Member memberLogin = userService.login(userId, password);

        return memberLogin != null ? ResponseEntity.ok(memberLogin) : ResponseEntity.notFound().build();
    }



}
