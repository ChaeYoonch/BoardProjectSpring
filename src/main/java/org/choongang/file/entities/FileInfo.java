package org.choongang.file.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseMemberEntity;

import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
public class FileInfo extends BaseMemberEntity {
    @Id @GeneratedValue
    private Long seq; // 서버에 업로드 될 파일 이름 : seq.확장자

    @Column(length = 45, nullable = false)
    private String gid = UUID.randomUUID().toString(); // 그룹 ID | 필수

    @Column(length = 45)
    private String location; // 그룹 안에 세부 위치

    @Column(length = 80, nullable = false)
    private String fileName; // 파일명 | 필수

    @Column(length = 30)
    private String extension; // 파일 확장자 | 없는 경우도 있으므로 nullable -> null 로 냅둠

    @Column(length = 80)
    private String contentType; // 파일 형식

    private boolean done; // 그룹 작업 완료 여부
}