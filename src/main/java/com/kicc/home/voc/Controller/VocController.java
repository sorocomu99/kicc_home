package com.kicc.home.voc.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/voc")
@RequiredArgsConstructor
public class VocController {
    @Value("/voc")
    private String directory;

    // 채용 - 공지사항 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/voc";
    }

    // 채용 - 공지사항 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/voc_detail";
    }

    // 채용 - 공지사항 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/voc_update";
//    }

    // 채용 - 공지사항 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/voc";
//    }
}
