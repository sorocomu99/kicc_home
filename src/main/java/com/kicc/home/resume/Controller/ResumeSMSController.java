package com.kicc.home.resume.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/resume/sms")
@RequiredArgsConstructor
public class ResumeSMSController {

    @Value("/resume")
    private String directory;

    // 선택 메일 발송 화면 이동
    @PostMapping("/page")
    public String page(@RequestParam("resume[]") List<String> params, Model model) {
        model.addAttribute("params", params);
        return directory + "/resume_sms";
    }
}
