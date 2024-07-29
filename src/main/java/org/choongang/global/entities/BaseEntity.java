package org.choongang.global.entities;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter @Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Q 클래스 생성하는 역할
public abstract class BaseEntity { // 다른 엔티티가 공유할 목적으로 생성

}