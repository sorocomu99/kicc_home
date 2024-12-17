package com.kicc.home.bridging.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bridging/introduce")
@RequiredArgsConstructor
public class IntroduceController {
    @Value("/bridging/introduce")
    private String directory;

    // 브리징 - 소개 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/introduce";
    }

    // 브리징 - 소개 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/introduce_insert";
    }

    // 브리징 - 소개 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/introduce_insert";
//    }

    // 브리징 - 소개 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/introduce_update";
    }

    // 브리징 - 소개 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/introduce_update";
//    }

    // 브리징 - 소개 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/introduce";
//    }
}
