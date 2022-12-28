package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo.domain.BoardVO;
import com.demo.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/board/*")
public class BoardController {

	// 템플릿 주소 : https://adminlte.io/themes/AdminLTE/pages/forms/general.html
	
	@Autowired
	private BoardService boardService;
	 //폼
	@GetMapping("/write")
	public void write() {
		log.info("write called");
		
	}
	
	//저장
	@PostMapping("/write")
	public String write(BoardVO vo, RedirectAttributes rttr) {
		log.info("입력데이터:" + vo);
		
		boardService.write(vo);
		
		rttr.addFlashAttribute("msg","write");
		
		return "redirect:/board/list";
	}
	//리스트
	@GetMapping("/list")
	public void list(Model model) {
		log.info("write called");
		
		List<BoardVO> list = boardService.getList();
		model.addAttribute("list", list);
	}
	
	//읽기.요청 		list?bno=3
	//@GetMapping("/get") 한개
	//읽기및 수정폼
	@GetMapping(value = {"/get","/modify"})
	public void get(Long bno, Model model ) {
		log.info("게시물번호 : " + bno);
		
		BoardVO board =boardService.get(bno);
		model.addAttribute("board", board);
	} 
	//글수정
	@PostMapping("/modify")
	public String modify(BoardVO vo, RedirectAttributes rttr) {
		log.info("수정 내용:" + vo);
		
		//연동
		boardService.modify(vo);
		
		rttr.addFlashAttribute("msg", "modify");
	
		return "redirect:/board/list";
	}
	
}
