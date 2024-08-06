package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 파일 정보 가져오는 데 필요함!
public class FileDeleteService {
    private final FileInfoService infoService; // 파일 삭제할 때 필요

}