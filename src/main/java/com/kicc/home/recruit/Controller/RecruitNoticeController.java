package com.kicc.home.recruit.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/recruit/notice")
@RequiredArgsConstructor
public class RecruitNoticeController {
    @Value("/recruit/notice")
    private String directory;

    // 채용 - 공지사항 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/notice";
    }

    // 채용 - 공지사항 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/notice_insert";
    }

    // 채용 - 공지사항 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/notice_insert";
//    }

    // 채용 - 공지사항 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/notice_update";
    }

    // 채용 - 공지사항 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/notice_update";
//    }

    // 채용 - 공지사항 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/notice";
//    }
}
