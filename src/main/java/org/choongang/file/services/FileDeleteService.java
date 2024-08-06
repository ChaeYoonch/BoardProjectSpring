package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.repositories.FileInfoRepository;
import org.choongang.member.MemberUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 파일 정보 가져오는 데 필요함!
public class FileDeleteService {
    private final FileInfoService infoService; // 파일 삭제할 때 필요
    private final FileInfoRepository infoRepository;
    private final MemberUtil memberUtil; // 얘로 체크 가능!
}