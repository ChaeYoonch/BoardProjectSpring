package org.choongang.file.controllers;

import lombok.RequiredArgsConstructor;
import org.choongang.file.entities.FileInfo;
import org.choongang.file.services.FileDeleteService;
import org.choongang.file.services.FileDownloadService;
import org.choongang.file.services.FileInfoService;
import org.choongang.file.services.FileUploadService;
import org.choongang.global.rests.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class FileController { //REST 형태로 작업
    // 파일 관련 의존성 주입
    private final FileUploadService uploadService;
    private final FileDownloadService downloadService;
    private final FileInfoService infoService;
    private final FileDeleteService deleteService;

    @PostMapping("/upload") // file 은 post 형태로 넘어오기 때문!
    public ResponseEntity<JSONData> upload(@RequestPart("file") MultipartFile[] files, // "file" 이 이름 | 1개는 낱개로 | 여러 개는 배열 형태로
                                           @RequestParam(name="gid", required = false) String gid,
                                           @RequestParam(name="location", required = false) String location) { // Multipart file 형태

        List<FileInfo> items = uploadService.upload(files, gid, location); // * items
        HttpStatus status = HttpStatus.CREATED; // ** status
        JSONData data = new JSONData(items); // * items 연동
        data.setStatus(status); // ** status 연동

        return ResponseEntity.status(status).body(data); // ** status 연동
    }

    @GetMapping("/download/{seq}")
    public void download(@PathVariable("seq") Long seq) { // 출력 = servletOutputStream 이 하므로 void
        downloadService.download(seq); // Long seq 의 seq 연동
    }

    @DeleteMapping("/delete/{seq}")
    public JSONData delete(@PathVariable("seq") Long seq) { // 낱개 삭제
        FileInfo data = deleteService.delete(seq);

        return new JSONData(data); // 위의 data 연결 | JSON 데이터 형태
    } // 반환값 = 삭제된 데이터

    @DeleteMapping("/deletes/{gid}")
    public JSONData deletes(@PathVariable("gid")String gid, @RequestParam(name="location", required = false) String location) { // 목록 삭제
        List<FileInfo> items = deleteService.delete(gid, location);

        return new JSONData(items); // 위의 items 연동
    }

    @GetMapping("/info/{seq}")
    public JSONData get(Long seq) { // 개별 조회

    }
}