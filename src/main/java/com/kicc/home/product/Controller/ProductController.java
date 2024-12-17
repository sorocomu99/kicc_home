package com.kicc.home.product.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Value("/product")
    private String directory;

    // 메인 비주얼 목록 조회
    @GetMapping("/info")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/product";
    }

    // 메인 비주얼 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/product";
//    }

    // 메인 비주얼 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/product";
//    }
}
