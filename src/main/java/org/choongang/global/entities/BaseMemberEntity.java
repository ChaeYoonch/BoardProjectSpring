package org.choongang.global.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Getter @Setter
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseMemberEntity extends BaseEntity { // 회원 관련만 작성

    @CreatedBy
    @Column(length = 65, updatable = false) // 수정 불가!
    private String createdBy; // 추가할 때만 값 O, 수정 X

    @LastModifiedBy
    @Column(length = 65, insertable = false) // 수정 불가!
    private String modifiedBy; // 수정할 때만 값 O
}