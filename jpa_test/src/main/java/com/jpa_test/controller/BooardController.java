package com.jpa_test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jpa_test.dto.BoardSaveRequestDto;
import com.jpa_test.model.Board;
import com.jpa_test.service.BoardService;

@Controller
public class BooardController {
	@Autowired
	private BoardService boardService;
	// http://localhost:9090/list/?page=1
	@GetMapping({"", "/", "list"})
	public String list(@PageableDefault(size = 3, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
		// 서비스 객체에 접근해서 목록(오브젝트)가져 와야 한다
		Page<Board> board = boardService.글목록보기(pageable);
		model.addAttribute("boards", board);
		return "list";	
	}
//	@GetMapping("/listPage")
//	public Page<Board> listPage(@PageableDefault(size = 1, sort = "id", direction = Direction.DESC) Pageable pageable, Model model) {
//		// 서비스 객체에 접근해서 목록(오브젝트)가져 와야 한다
//		Page<Board> board = boardService.글목록보기(pageable);
//		model.addAttribute("boards", board);
//		return board;	
//	}
//	
	// 페이지 요청
	@GetMapping("/saveForm")
	public String saveForm() { 
		
		return "saveForm";
	}
	@PostMapping("/save")
	@ResponseBody // 이 어노테이션을 안쓰더라도 DB에는 저장이 된다.
	public String save(@RequestBody BoardSaveRequestDto dto) {
		// 서비스 객체로가서 DB저장 요청 해야한다.
		boardService.글쓰기(dto);
		return "ok";
	}
}
