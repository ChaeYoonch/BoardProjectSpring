package org.choongang.board.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.choongang.global.entities.BaseMemberEntity;

@Data
@Entity
@Builder
@NoArgsConstructor @AllArgsConstructor
public class Board extends BaseMemberEntity { // 게시판 설정

}