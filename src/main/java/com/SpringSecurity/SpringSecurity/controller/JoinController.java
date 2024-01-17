package com.SpringSecurity.SpringSecurity.controller;

import com.SpringSecurity.SpringSecurity.dto.JoinDto;
import com.SpringSecurity.SpringSecurity.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final JoinService joinService;

    @GetMapping("/join")
    public String join() {
        return "join";
    }

    @PostMapping("/join")
    public String joinProc(JoinDto joinDto) {
        joinService.joinProcess(joinDto);
        return "redirect:/login";
    }
}
