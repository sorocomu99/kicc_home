package com.kicc.home.popup.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/popup")
@RequiredArgsConstructor
public class PopupController {

    @Value("/popup")
    private String directory;

    // 팝업 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/popup";
    }

    // 팝업 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/popup_insert";
    }

    // 팝업 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/popup_insert";
//    }

    // 팝업 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/popup_update";
    }

    // 팝업 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/popup_update";
//    }

    // 팝업 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/popup";
//    }
}
