package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.repositories.FileInfoRepository;
import org.choongang.member.MemberUtil;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor // 파일 정보 가져오는 데 필요함!
public class FileDeleteService {
    private final FileInfoService infoService; // 파일 삭제할 때 필요
    private final FileInfoRepository infoRepository;
    private final MemberUtil memberUtil; // 얘로 체크 가능!

    public FileInfo delete(Long seq) { // 낱개 삭제
        FileInfo data = infoService.get(seq); // seq 를 가져옴
        String filePath = data.getFilePath(); // 위의 data 연동 -> 가져온 seq 연결 O
        String createdBy = data.getCreatedBy(); // 위의 data 연동 -> 업로드한 회원 이메일
    }
}