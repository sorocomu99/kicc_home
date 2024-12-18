package com.kicc.home.account.Controller;

import com.kicc.home.account.Service.AccountService;
import com.kicc.home.account.vo.Account;
import com.kicc.home.dao.account.AccountDAO;
import com.kicc.home.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Value("/account")
    private String directory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountDAO accountDAO;

    // 관리자 목록 조회
    @GetMapping("/list")
    public String selectList(Model model) {
        model.addAttribute("", "");
        return directory + "/account";
    }

    // 관리자 등록 페이지 이동
    @GetMapping("/insert")
    public String insert(Model model) {
        return directory + "/account_insert";
    }

    // 관리자 등록
//    @PostMapping("/insert")
//    electronic String insert() {
//        return directory + "/account_insert";
//    }

    // 관리자 수정 페이지 이동
    @GetMapping("/detail")
    public String detail(Model model) {
        model.addAttribute("", "");
        return directory + "/account_update";
    }

    // 관리자 수정
//    @PostMapping("/update")
//    electronic String update() {
//        return directory + "/account_update";
//    }

    // 관리자 삭제
//    @PostMapping("/delete")
//    electronic String delete() {
//        return directory + "/account";
//    }


    @PostMapping("/insert")
    public ResponseEntity<String> insertAccount(@RequestBody Account account) {

        Account jwtInfo = jwtUtil.getAuthAccount();
        String jwtName = jwtInfo.getName();
        account.setUpdateUser(jwtName);

        accountService.insert(account);
        return ResponseEntity.ok("관리자 등록 완료.");
    }
    @PostMapping("/update")
    public ResponseEntity<String> updateAccount(@RequestBody Account account) {

        Account jwtInfo = jwtUtil.getAuthAccount();
        String jwtName = jwtInfo.getName();
        account.setUpdateUser(jwtName);

        accountService.update(account);
        return ResponseEntity.ok("관리자 수정 완료.");
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable String id) {
        boolean isDeleted = accountService.delete(id);
        if (isDeleted) {
            return ResponseEntity.ok("관리자 삭제 완료");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("계정을 찾을 수 없습니다.");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginAction(@RequestBody Map<String, String> credentials) {
        String id = credentials.get("id");
        String password = credentials.get("password");

        if (id == null || password == null) {
            return ResponseEntity.badRequest().body("ID와 비밀번호를 입력해주세요.");
        }

        Account vo = new Account();
        vo.setId(id);

        Account account = accountService.getAccountById(vo);
        if (account == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("존재하지 않는 사용자입니다.");
        }

        if (account.getLoginFailCnt() >= 5) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호를 5회 이상 틀리셨습니다.");
        }

        if (!passwordEncoder.matches(password, account.getPassword())) {
            accountDAO.updateLogin(id, false);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("비밀번호가 일치하지 않습니다.");
        }

        accountDAO.updateLogin(id, true);
        String token = jwtUtil.generateToken(account);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/list")
    public ResponseEntity<?> getAccounts() {
        try {
            List<Account> accounts = accountService.getList();
            return ResponseEntity.ok(accounts);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }

    @PostMapping("/get")
    public ResponseEntity<?> getAccount(@RequestBody Account account) {
        try {
            Account result = accountService.getAccountById(account);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Internal Server Error: " + e.getMessage());
        }
    }
}
