package com.kicc.home.faq.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/faq/first")
@RequiredArgsConstructor
public class FaqFirstCategoryController {

    @Value("/faq/category1/")
    private String directory;

    // 1차 카테고리 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/faq";
    }

    // 1차 카테고리 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/faq_insert";
    }

    // 1차 카테고리 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/faq_insert";
//    }

    // 1차 카테고리 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/faq_update";
    }

    // 1차 카테고리 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/faq_update";
//    }

    // 1차 카테고리 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/faq";
//    }
}