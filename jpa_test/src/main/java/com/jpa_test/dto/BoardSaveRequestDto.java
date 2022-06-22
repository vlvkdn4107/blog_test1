package com.jpa_test.dto;

import com.jpa_test.model.Board;

import lombok.Data;

@Data
public class BoardSaveRequestDto {
	private String title;
	private String content;
	
	// 한단계 업그레이드 해보자!
	public static Board toEntity(BoardSaveRequestDto dto) {
		Board boardEntity = Board.builder()
				.title(dto.getTitle())
				.content(dto.getContent())
				.build();
		return boardEntity;
	}
	
}
