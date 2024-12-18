package com.kicc.home.resume.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/resume/mail")
@RequiredArgsConstructor
public class ResumeMailController {

    @Value("/resume")
    private String directory;

    // 선택 메일 발송 화면 이동
    @PostMapping("/page")
    public String page(@RequestParam("resume[]") List<String> params, Model model) {
        model.addAttribute("params", params);
        return directory + "/resume_mail";
    }
}
