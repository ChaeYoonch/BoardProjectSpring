package org.choongang.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Q 클래스 생성하는 역할
public abstract class BaseEntity { // 다른 엔티티가 공유할 목적으로 생성

    @CreatedDate
    @Column(updatable = false) // 처음 등록 시에만! 수정 X
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(insertable = false) // 추가 X | 수정할 때는 O
    private LocalDateTime modifiedAt;

    @Column(insertable = false) // 추가 X | 수정할 때는 O
    private LocalDateTime deleteAt;
}