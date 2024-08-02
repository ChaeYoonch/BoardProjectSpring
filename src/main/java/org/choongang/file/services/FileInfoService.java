package org.choongang.file.services;

import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.repositories.FileInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FileInfoService {

    private final FileInfoRepository fileInfoRepository;

    /**
     * 파일 1개 조회
     * @param seq : 파일 등록 번호
     * @return
     */
    public FileInfo get(Long seq) {

        return null;
    }

    public List<FileInfo> getList(String gid, String location) // gid - 그룹 ID 로 조회
}