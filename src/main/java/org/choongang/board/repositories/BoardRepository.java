package org.choongang.board.repositories;

import org.choongang.board.entities.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, String> {

}