package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileDownloadService {
    private final FileInfoService infoService; // 의존성 주입

    public void download(Long seq) {

    }
}