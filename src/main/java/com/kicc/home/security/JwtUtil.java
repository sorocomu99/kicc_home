package com.kicc.home.security;

import com.kicc.home.account.vo.Account;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

@Component
public class JwtUtil {

    private static final String SECRET = hashTo32Characters("test");
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    private final long validityInMs = 3600000;

    public String generateToken(Account account) {
        Map<String, Object> claims = new HashMap<>();

        claims.put("idx", account.getIdx());
        claims.put("id", account.getId());
        claims.put("password", account.getPassword());
        claims.put("name", account.getName());

        // 권한 관련 필드 추가
        claims.put("adminAccountYn", account.getAdminAccountYn());
        claims.put("popupManageYn", account.getPopupManageYn());
        claims.put("inquiryHandlerYn", account.getInquiryHandlerYn());
        claims.put("privacyProcessYn", account.getPrivacyProcessYn());
        claims.put("termsManageYn", account.getTermsManageYn());
        claims.put("efinanceInquiryYn", account.getEfinanceInquiryYn());
        claims.put("mainVisualYn", account.getMainVisualYn());
        claims.put("businessAreaYn", account.getBusinessAreaYn());
        claims.put("productIntroYn", account.getProductIntroYn());
        claims.put("posManageYn", account.getPosManageYn());
        claims.put("kioskManageYn", account.getKioskManageYn());
        claims.put("cardTerminalYn", account.getCardTerminalYn());
        claims.put("signpadManageYn", account.getSignpadManageYn());
        claims.put("etcManageYn", account.getEtcManageYn());
        claims.put("companyIntroYn", account.getCompanyIntroYn());
        claims.put("shareholderMeetingYn", account.getShareholderMeetingYn());
        claims.put("irLetterYn", account.getIrLetterYn());
        claims.put("electronicNoticeYn", account.getElectronicNoticeYn());
        claims.put("bridgingIntroYn", account.getBridgingIntroYn());
        claims.put("bridgingActivityYn", account.getBridgingActivityYn());
        claims.put("newsManageYn", account.getNewsManageYn());
        claims.put("resumeManageYn", account.getResumeManageYn());
        claims.put("noticeHrYn", account.getNoticeHrYn());
        claims.put("noticeCustomerYn", account.getNoticeCustomerYn());
        claims.put("documentManageYn", account.getDocumentManageYn());
        claims.put("vocInquiryYn", account.getVocInquiryYn());
        claims.put("faqManageYn", account.getFaqManageYn());
        claims.put("curriculumManageYn", account.getCurriculumManageYn());
        claims.put("seminarApplyYn", account.getSeminarApplyYn());

        return Jwts.builder()
                .setClaims(claims) // 클레임 설정
                .setSubject(account.getId()) // 주제 설정 (ID)
                .setIssuedAt(new Date()) // 발행 시간
                .setExpiration(new Date(System.currentTimeMillis() + validityInMs)) // 만료 시간
                .signWith(key)
                .compact();
    }

    public static String hashTo32Characters(String text) {
        try {
            // Create the MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Perform the hashing
            byte[] encodedHash = digest.digest(text.getBytes());

            // Convert the hash to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedHash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            // Truncate or pad the string to 32 characters
            if (hexString.length() > 32) {
                return hexString.substring(0, 32); // Truncate to 32 characters
            } else {
                while (hexString.length() < 32) {
                    hexString.append('0'); // Pad with '0' if less than 32 characters
                }
                return hexString.toString();
            }
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing with SHA-256", e);
        }
    }

    public Account parseToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key) // 키 설정
                .build()
                .parseClaimsJws(token)
                .getBody();

        Account account = new Account();
        account.setIdx(claims.get("idx", Long.class));
        account.setId(claims.get("id", String.class));
        account.setPassword(claims.get("password", String.class));
        account.setName(claims.get("name", String.class));

        // 권한 관련 필드 복원
        account.setAdminAccountYn(claims.get("adminAccountYn", String.class));
        account.setPopupManageYn(claims.get("popupManageYn", String.class));
        account.setInquiryHandlerYn(claims.get("inquiryHandlerYn", String.class));
        account.setPrivacyProcessYn(claims.get("privacyProcessYn", String.class));
        account.setTermsManageYn(claims.get("termsManageYn", String.class));
        account.setEfinanceInquiryYn(claims.get("efinanceInquiryYn", String.class));
        account.setMainVisualYn(claims.get("mainVisualYn", String.class));
        account.setBusinessAreaYn(claims.get("businessAreaYn", String.class));
        account.setProductIntroYn(claims.get("productIntroYn", String.class));
        account.setPosManageYn(claims.get("posManageYn", String.class));
        account.setKioskManageYn(claims.get("kioskManageYn", String.class));
        account.setCardTerminalYn(claims.get("cardTerminalYn", String.class));
        account.setSignpadManageYn(claims.get("signpadManageYn", String.class));
        account.setEtcManageYn(claims.get("etcManageYn", String.class));
        account.setCompanyIntroYn(claims.get("companyIntroYn", String.class));
        account.setShareholderMeetingYn(claims.get("shareholderMeetingYn", String.class));
        account.setIrLetterYn(claims.get("irLetterYn", String.class));
        account.setElectronicNoticeYn(claims.get("electronicNoticeYn", String.class));
        account.setBridgingIntroYn(claims.get("bridgingIntroYn", String.class));
        account.setBridgingActivityYn(claims.get("bridgingActivityYn", String.class));
        account.setNewsManageYn(claims.get("newsManageYn", String.class));
        account.setResumeManageYn(claims.get("resumeManageYn", String.class));
        account.setNoticeHrYn(claims.get("noticeHrYn", String.class));
        account.setNoticeCustomerYn(claims.get("noticeCustomerYn", String.class));
        account.setDocumentManageYn(claims.get("documentManageYn", String.class));
        account.setVocInquiryYn(claims.get("vocInquiryYn", String.class));
        account.setFaqManageYn(claims.get("faqManageYn", String.class));
        account.setCurriculumManageYn(claims.get("curriculumManageYn", String.class));
        account.setSeminarApplyYn(claims.get("seminarApplyYn", String.class));

        return account;
    }

    public Account getAuthAccount() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof String) {
            String token = (String) authentication.getPrincipal();

            return parseToken(token);
        }

        throw new IllegalStateException("만료되었거나 정상적이지 않은 토큰입니다.");
    }
}

