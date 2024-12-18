package com.kicc.home.ir.vo;

import lombok.Data;
import java.sql.Date;

@Data
public class IrLetter {
    private Long idx;             // 고유 번호
    private String subject;       // 제목
    private String writer;        // 작성자
    private Date writeDate;       // 작성일
    private Integer hits;         // 조회수
    private String filename;      // 저장된 파일 이름
    private String orgFilename;   // 원본 파일 이름
    private String cid;           // 작성자 CID
    private Long filesize;        // 파일 크기
    private String contents;      // 내용
    private String hideYn;        // 숨김 여부 (Y/N)
    private String noticeYn;      // 공지 여부 (Y/N)
    private String activeYn;      // 활성화 여부 (Y/N)
    private String array;         // 정렬 순서
    private Date updateDate;      // 수정일
    private String updateUser;    // 수정자
}