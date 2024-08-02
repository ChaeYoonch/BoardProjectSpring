package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.constants.FileStatus;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.exceptions.FileNotFoundException;
import org.choongang.file.repositories.FileInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileInfoService {

    private final FileInfoRepository infoRepository;

    /**
     * 파일 1개 조회
     * @param seq : 파일 등록 번호
     * @return
     */
    public FileInfo get(Long seq) {
        FileInfo item = infoRepository.findById(seq).orElseThrow(FileNotFoundException::new);
        /**
         * 2차 가공
         * 1. 파일을 접근할 수 있는 URL - 보여주기 위한 목적
         * 2. 파일을 접근할 수 있는 PATH (경로) - 파일 삭제, 다운로드 등
         */

        addFileInfo(item); // 객체 이므로 그냥 넣어도 참조 Ok

        return item;
    }

    /**
     * 파일 목록 조회
     * @param gid
     * @param location
     * @param status - ALL : 완료 + 미완료 | DONE : 완료 | UNDONE : 미완료
     * @return
     */
    public List<FileInfo> getList(String gid, String location, FileStatus status) {// gid - 그룹 ID 로 조회
        return null;
    }

    /**
     * 파일 정보 추가 처리
     *  - fileUrl, filePath
     * @param item
     */
    public void addFileInfo(FileInfo item) {// 공통 메서드 정의

    }
}