package com.kicc.home.resume.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resume")
@RequiredArgsConstructor
public class ResumeController {

    @Value("/resume")
    private String directory;

    // 관리자 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/resume";
    }

    // 관리자 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/resume_insert";
    }

    // 관리자 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/resume_detail";
    }

    // 관리자 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/resume_update";
//    }

    // 관리자 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/resume";
//    }
}
