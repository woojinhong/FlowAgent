package com.post.kr.flowagent.iam.interfaces.controller;


import com.post.kr.flowagent.iam.application.dto.SignUpRequest;
import com.post.kr.flowagent.iam.application.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth") // URL 경로를 /auth로 변경
@RequiredArgsConstructor
public class UserController {

    private final AuthService authService;

    // 1. 회원가입 폼을 보여주는 메서드
    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        // Thymeleaf 폼에서 사용할 수 있도록 빈 DTO 객체를 모델에 담아 전달
        model.addAttribute("signUpRequest", new SignUpRequest("", "", "", "", ""));
        return "auth/signup"; // templates/auth/signup.html 파일을 렌더링
    }

    // 2. 회원가입 폼 제출을 처리하는 메서드
    @PostMapping("/signup")
    public String processSignUp(@Valid @ModelAttribute SignUpRequest signUpRequest,
                                BindingResult bindingResult) {
        // 유효성 검사에서 에러가 발생한 경우
        if (bindingResult.hasErrors()) {
            return "auth/signup"; // 다시 회원가입 폼으로 돌려보냄 (에러 메시지 표시)
        }

        try {
            authService.signUp(signUpRequest);
        } catch (IllegalArgumentException e) {
            // 이메일 중복과 같은 비즈니스 로직 에러 처리
            bindingResult.rejectValue("email", "duplicate", e.getMessage());
            return "auth/signup";
        }

        // 회원가입 성공 시 로그인 페이지로 리다이렉트
        return "redirect:/auth/login";
    }
}