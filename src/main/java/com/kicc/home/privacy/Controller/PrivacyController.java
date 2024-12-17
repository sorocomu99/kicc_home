package com.kicc.home.privacy.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/privacy")
@RequiredArgsConstructor
public class PrivacyController {

    @Value("/privacy")
    private String directory;

    // 개인정보처리방침 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/privacy";
    }

    // 개인정보처리방침 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/privacy_insert";
    }

    // 개인정보처리방침 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/privacy_insert";
//    }

    // 개인정보처리방침 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/privacy_update";
    }

    // 개인정보처리방침 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/privacy_update";
//    }

    // 개인정보처리방침 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/privacy";
//    }
}
