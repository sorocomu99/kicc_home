package com.kicc.home.account.vo;

import lombok.Data;
import java.util.Date;

@Data
public class Account {
    private Long idx; //키값
    private String id;
    private String password;
    private String name; // 사용자 이름
    private Date insertDate; // 등록일
    private Date updateDate; // 수정일
    private String updateUser; // 수정자

    // 권한 관련 필드
    private String adminAccountYn;
    private String popupManageYn;
    private String inquiryHandlerYn;
    private String privacyProcessYn;
    private String termsManageYn;
    private String efinanceInquiryYn;
    private String mainVisualYn;
    private String businessAreaYn;
    private String productIntroYn;
    private String posManageYn;
    private String kioskManageYn;
    private String cardTerminalYn;
    private String signpadManageYn;
    private String etcManageYn;
    private String companyIntroYn;
    private String shareholderMeetingYn;
    private String irLetterYn;
    private String electronicNoticeYn;
    private String bridgingIntroYn;
    private String bridgingActivityYn;
    private String newsManageYn;
    private String resumeManageYn;
    private String noticeHrYn;
    private String noticeCustomerYn;
    private String documentManageYn;
    private String vocInquiryYn;
    private String faqManageYn;
    private String curriculumManageYn;
    private String seminarApplyYn;

    private int loginFailCnt; // 로그인 실패 횟수
}
