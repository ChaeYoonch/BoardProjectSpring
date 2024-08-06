package org.choongang.file.services;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileDownloadService {
    private final FileInfoService infoService; // 의존성 주입
    private final HttpServletResponse response; // 파일 가져오기 위해 사용

    public void download(Long seq) {

    }
}