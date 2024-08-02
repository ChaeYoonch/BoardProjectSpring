package org.choongang.file.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseEntity;

@Data
@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
public class FileInfo extends BaseEntity {
    @Id
    @GeneratedValue
    private Long seq; // 서버에 업로드 될 파일 이름 : seq.확장자

    private String gid; // 그룹 ID
}