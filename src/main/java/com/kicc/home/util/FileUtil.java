package com.kicc.home.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;
import java.util.UUID;

public class FileUtil {

    private static final String UPLOAD_DIR;

    static {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            UPLOAD_DIR = "C:/uploads/"; // 윈도우 경로
        } else {
            UPLOAD_DIR = "/home/uploads/"; // 리눅스 경로
        }
    }

    /**
     * 파일 저장 메서드
     * @param file MultipartFile 객체
     * @return 저장된 파일 이름 (UUID 포함)
     * @throws IOException 파일 저장 실패 예외
     */
    public static String saveFile(MultipartFile file) throws IOException {
        // 원본 파일명
        String originalFilename = file.getOriginalFilename();

        // 중복 방지를 위한 UUID 적용
        String savedFilename = UUID.randomUUID() + "_" + originalFilename;

        // 저장 경로 설정
        Path filePath = Paths.get(UPLOAD_DIR, savedFilename);
        Files.createDirectories(filePath.getParent());

        // 파일 저장
        file.transferTo(filePath.toFile());

        return savedFilename;
    }

    /**
     * 파일 삭제 메서드
     * @param filename 저장된 파일명
     * @throws IOException 파일 삭제 실패 예외
     */
    public static void deleteFile(String filename) throws IOException {
        Path filePath = Paths.get(UPLOAD_DIR, filename);
        Files.deleteIfExists(filePath);
    }

    /**
     * 저장 경로 반환
     * @return 운영체제에 맞는 저장 경로
     */
    public static String getUploadDir() {
        return UPLOAD_DIR;
    }
}
