package org.choongang.global.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@MappedSuperclass
public abstract class BaseEntity { // 다른 엔티티가 공유할 목적으로 생성

}