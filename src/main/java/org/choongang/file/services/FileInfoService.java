package org.choongang.file.services;

import com.querydsl.core.BooleanBuilder;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.choongang.file.constants.FileStatus;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.entities.QFileInfo;
import org.choongang.file.exceptions.FileNotFoundException;
import org.choongang.file.repositories.FileInfoRepository;
import org.choongang.global.configs.FileProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

import static org.springframework.data.domain.Sort.Order.asc;

@Service
@RequiredArgsConstructor
@EnableConfigurationProperties(FileProperties.class)
public class FileInfoService {

    private final FileInfoRepository infoRepository;
    private final FileProperties properties;
    private final HttpServletRequest request; // url 에서 ContextPath 연결 위해

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

    public List<FileInfo> getList(String gid, String location, FileStatus status) { // gid - 그룹 ID 로 조회

        QFileInfo fileInfo = QFileInfo.fileInfo;
        BooleanBuilder andBuilder = new BooleanBuilder();
        andBuilder.and(fileInfo.gid.eq(gid)); // gid 확인 조건식

        if (StringUtils.hasText(location)) {
            andBuilder.and(fileInfo.location.eq(location)); // location 확인 조건식
        }

        if (status != FileStatus.ALL) { // All 이 아닌 경우에는 체크 X
            andBuilder.and(fileInfo.done.eq(status == FileStatus.DONE)); // status 확인 조건식
        }

        List<FileInfo> items = (List<FileInfo>)infoRepository.findAll(andBuilder, Sort.by(asc("createdAt")));

        return null;
    } // status -> done => 메서드 오버로드 (다양한 유형 -> 편하게 쓰기 위하여 사용) ex) gid / gid, location 등

    public List<FileInfo> getList(String gid, String location) {
        return getList(gid, location, FileStatus.DONE); // status 로 확인
    }

    public List<FileInfo> getList(String gid) {
        return getList(gid, null, FileStatus.DONE); // gid 로 확인
    }

    /**
     * 파일 정보 추가 처리
     *  - fileUrl, filePath
     * @param item
     */

    public void addFileInfo(FileInfo item) {// 공통 메서드 정의
        String fileUrl = getFileUrl(item);
        String filePath = getFilePath(item);

        item.setFileUrl(fileUrl);
        item.setFilePath(filePath);
    }

    // 브라우저 접근 주소
    public String getFileUrl(FileInfo item) { // seq : 파일 등록 번호로 찾을 수 있음 -> 파일 Url
        return request.getContextPath() + properties.getUrl() + "/" + getFolder(item.getSeq()) + "/" + getFileName(item); // ContextPath & Url & Folder & FileName
    }

    // 서버 업로드 경로
    public String getFilePath(FileInfo item) { // seq : 파일 등록 번호로 찾을 수 있음 -> 파일 경로
        return properties.getPath() + "/" + getFolder(item.getSeq()) + "/" + getFileName(item);
    }

    public String getFolder(long seq) { // seq : 파일 등록 번호로 찾을 수 있음
       return String.valueOf(seq % 10L); // 10개씩 나눔
    }

    public String getFileName(FileInfo item) {
        String fileName = item.getSeq() + Objects.requireNonNullElse(item.getExtension(), "");
        return fileName;
    }
}