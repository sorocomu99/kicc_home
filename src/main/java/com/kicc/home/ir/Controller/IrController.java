package com.kicc.home.ir.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kicc.home.account.vo.Account;
import com.kicc.home.dao.ir.IrDAO;
import com.kicc.home.ir.Service.IrService;
import com.kicc.home.ir.vo.IrLetter;
import com.kicc.home.security.JwtUtil;
import com.kicc.home.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/ir")
@RequiredArgsConstructor
public class IrController {

    @Value("/ir")
    private String directory;

    @Autowired
    private IrService irService;

    @Autowired
    private IrDAO irDAO;

    @Autowired
    private JwtUtil jwtUtil;

    // 관리자 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/ir";
    }

    // 관리자 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/ir_insert";
    }

    // 관리자 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/ir_insert";
//    }

    // 관리자 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/ir_update";
    }

    // 관리자 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/ir_update";
//    }

    // 관리자 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/ir";
//    }

    @PostMapping("/list")
    public ResponseEntity<?> getIrLetters(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size,
            @RequestParam(required = false) String searchType,
            @RequestParam(required = false) String keyword) {
        try {
            List<IrLetter> letters = irService.getPagedIrLetters(page, size, searchType, keyword);

            return ResponseEntity.ok(letters);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<?> registerIrLetter( @RequestPart("irLetter") String irLetterJson,
                                               @RequestPart(value = "file", required = false) MultipartFile file
    ) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            IrLetter irLetter = objectMapper.readValue(irLetterJson, IrLetter.class);


            Account jwtInfo = jwtUtil.getAuthAccount();
            String jwtName = jwtInfo.getName();
            irLetter.setWriter(jwtName);
            irLetter.setUpdateUser(jwtName);

            if (file != null && !file.isEmpty()) {
                String savedFilename = FileUtil.saveFile(file);

                irLetter.setFilename(savedFilename);
                irLetter.setOrgFilename(file.getOriginalFilename());
                irLetter.setFilesize((long) file.getSize());
            }

            IrLetter savedIrLetter = irService.insert(irLetter);

            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "게시물 등록되었습니다.");
            response.put("data", savedIrLetter);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "게시물 등록에 실패했습니다.");
            errorResponse.put("error", e.getMessage());

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateIrLetter(
            @RequestPart("irLetter") String irLetterJson,
            @RequestPart(value = "file", required = false) MultipartFile file) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            IrLetter irLetter = objectMapper.readValue(irLetterJson, IrLetter.class);

            Account jwtInfo = jwtUtil.getAuthAccount();
            String jwtName = jwtInfo.getName();
            irLetter.setUpdateUser(jwtName);

            // 기존 데이터 조회
            IrLetter existingIrLetter = irService.findByIdx(irLetter.getIdx());
            if (existingIrLetter == null) {
                Map<String, Object> errorResponse = new HashMap<>();
                errorResponse.put("status", "error");
                errorResponse.put("message", "해당 게시물이 존재하지 않습니다.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
            }

            // 작성자는 기존 값 유지
            irLetter.setWriter(existingIrLetter.getWriter());

            // 파일 처리
            if (file != null && !file.isEmpty()) {
                // 기존 파일 삭제
                if (existingIrLetter.getFilename() != null) {
                    FileUtil.deleteFile(existingIrLetter.getFilename());
                }
                // 새 파일 저장
                String savedFilename = FileUtil.saveFile(file);
                irLetter.setFilename(savedFilename);
                irLetter.setOrgFilename(file.getOriginalFilename());
                irLetter.setFilesize((long) file.getSize());
            } else {
                // 파일 정보 유지
                irLetter.setFilename(existingIrLetter.getFilename());
                irLetter.setOrgFilename(existingIrLetter.getOrgFilename());
                irLetter.setFilesize(existingIrLetter.getFilesize());
            }

            irService.update(irLetter);

            // 응답 생성
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("message", "게시물이 성공적으로 수정되었습니다.");
            response.put("data", irLetter);

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("message", "게시물 수정에 실패했습니다.");
            errorResponse.put("error", e.getMessage());

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    @PostMapping("/delete/{idx}")
    public ResponseEntity<?> deleteIrLetter(@PathVariable Long idx) {
        boolean isDeleted = irService.delete(idx);
        if (isDeleted) {
            return ResponseEntity.ok("게시물 삭제 완료");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("게시물을 찾을 수 없습니다.");
        }
    }

    @PostMapping("/get")
    public ResponseEntity<?> getIrLetter(@RequestBody IrLetter irLetter) {
        try {
            IrLetter result = irService.findByIdx(irLetter.getIdx());
            irService.updateHits(irLetter.getIdx());
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }


}
