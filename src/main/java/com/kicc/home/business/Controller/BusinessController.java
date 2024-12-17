package com.kicc.home.business.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
@RequiredArgsConstructor
public class BusinessController {
    @Value("/business")
    private String directory;

    // 메인 비주얼 목록 조회
    @GetMapping("/info")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/business";
    }

    // 메인 비주얼 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/business";
//    }

    // 메인 비주얼 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/business";
//    }
}
