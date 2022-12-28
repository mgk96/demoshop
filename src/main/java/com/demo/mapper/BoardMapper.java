package com.demo.mapper;

import java.util.List;

import com.demo.domain.BoardVO;

public interface BoardMapper {
	
	//리스트
	public List<BoardVO> getList();
	
	//글저장
	public void write(BoardVO vo);
	
	//읽기
	public BoardVO get(Long bno);
	
	//수정
	public void modify(BoardVO vo);
	

}
