package org.zerock.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageMaker;
import org.zerock.service.BoardService;

@Controller
@RequestMapping("board/*")
public class BoardController {

	@Inject
	public BoardService service;
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public String register(){
		return "/board/register";
	}
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String register(BoardVO vo){
		try {
			service.regist(vo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void list(Model model) throws Exception{
		List<BoardVO> list = service.listAll();
		model.addAttribute("list",list);
	}
	
	@RequestMapping(value="/read", method=RequestMethod.GET)
	public void read(Model model, Integer bno) throws Exception{
		BoardVO vo = service.read(bno);
		model.addAttribute("read",vo);
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.GET)
	public void modify(Model model,Integer bno) throws Exception{
		model.addAttribute("read",service.read(bno));
	}
	@RequestMapping(value="/modify", method=RequestMethod.POST)
	public String modifyPOST(BoardVO vo) throws Exception{
		service.modify(vo);
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(@RequestParam Integer bno) throws Exception{
		service.remove(bno);
		return "redirect:/board/listCri";
	}
	
	@RequestMapping(value="/listCri", method=RequestMethod.GET)
	public void listAll(Criteria cri,Model model) throws Exception{
		List<BoardVO> list = service.listCriteria(cri);
		PageMaker pm = new PageMaker();
		pm.setCri(cri);
		pm.setTotalCount(service.getCount());
		model.addAttribute("pm",pm);
		model.addAttribute("list",list);
	}
}
