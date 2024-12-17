package com.kicc.home.stockholder.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stockholder")
@RequiredArgsConstructor
public class StockholderController {

    @Value("/stockholder")
    private String directory;

    // 관리자 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/stockholder";
    }

    // 관리자 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/stockholder_insert";
    }

    // 관리자 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/stockholder_insert";
//    }

    // 관리자 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/stockholder_update";
    }

    // 관리자 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/stockholder_update";
//    }

    // 관리자 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/stockholder";
//    }
}
