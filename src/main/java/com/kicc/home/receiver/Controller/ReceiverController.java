package com.kicc.home.receiver.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/receiver")
@RequiredArgsConstructor
public class ReceiverController {

    @Value("/receiver")
    private String directory;

    // 문의 수신 담당자 조회
    @GetMapping("/info")
    public String select(Model model) {
        model.addAttribute("", "");
        return directory + "/receiver";
    }

    // 문의 수신 담당자 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/receiver";
//    }

    // 문의 수신 담당자 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/receiver";
//    }
}
