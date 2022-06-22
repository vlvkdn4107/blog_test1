package com.jpa_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa_test.model.Board;

public interface BoardRepository extends JpaRepository<Board,Integer>{

}
