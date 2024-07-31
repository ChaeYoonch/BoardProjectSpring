package org.choongang.global.entities;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter

public abstract class BaseMemberEntity extends BaseEntity { // 회원 관련만 작성

}