package com.kicc.home.bridging.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bridging/activity")
@RequiredArgsConstructor
public class ActivityController {
    @Value("/bridging/activity")
    private String directory;

    // 브리징 - 활동 내역 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/activity";
    }

    // 브리징 - 활동 내역 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/activity_insert";
    }

    // 브리징 - 활동 내역 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/activity_insert";
//    }

    // 브리징 - 활동 내역 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/activity_update";
    }

    // 브리징 - 활동 내역 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/activity_update";
//    }

    // 브리징 - 활동 내역 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/activity";
//    }
}
