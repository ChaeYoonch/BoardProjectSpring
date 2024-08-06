package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.constants.FileStatus;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.repositories.FileInfoRepository;
import org.choongang.global.exceptions.UnAuthorizedException;
import org.choongang.member.MemberUtil;
import org.choongang.member.entities.Member;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.List;

@Service
@RequiredArgsConstructor // 파일 정보 가져오는 데 필요함!
public class FileDeleteService {
    private final FileInfoService infoService; // 파일 삭제할 때 필요
    private final FileInfoRepository infoRepository;
    private final MemberUtil memberUtil; // 얘로 체크 가능!

    public FileInfo delete(Long seq) { // 낱개 삭제
        FileInfo data = infoService.get(seq); // seq 를 가져옴 | **
        String filePath = data.getFilePath(); // 위의 data 연동 -> 가져온 seq 연결 O
        String createdBy = data.getCreatedBy(); // 위의 data 연동 -> 업로드한 회원 이메일

        Member member = memberUtil.getMember(); // member 값 가져옴
        if (!memberUtil.isAdmin() && StringUtils.hasText(createdBy) && memberUtil.isLogin() && !member.getEmail().equals(createdBy)) { // equals 가 아닌 경우
            throw new UnAuthorizedException(); // 권한 없음 예외 던짐!
        }

        /* 파일 삭제 */
        File file = new File(filePath);
        if (file.exists()) { // 존재하는 지 체크
            file.delete(); // 존재하면 파일 삭제 O
        }

        /* 파일 정보 삭제 */
        infoRepository.delete(data); // 위의 ** 쪽의 data 가져옴 | *
        infoRepository.flush();

        return data; // 위의 * data 연결
    }

    public List<FileInfo> delete(String gid, String loation, FileStatus status) { // 매개변수 : gid, location, status 3개

    }
}