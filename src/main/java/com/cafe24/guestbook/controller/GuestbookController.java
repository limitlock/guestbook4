package com.cafe24.guestbook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cafe24.guestbook.domain.Guestbook;
import com.cafe24.guestbook.service.GuestbookService;

@Controller
@RequestMapping("")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;

	@RequestMapping("/")
	public String index(Model model) {
		List<Guestbook> list = guestbookService.getMessageList();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping("/add")
	public String add(@ModelAttribute Guestbook guestbook) {
		guestbookService.insertMessage(guestbook);

		return "redirect:/";
	}

	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no",no);
		return "deleteform";
	}
	
	@RequestMapping("/delete")
	public String delete(@ModelAttribute Guestbook guestbook) {
		guestbookService.deleteMessage(guestbook);
		return "list";
	}
	
	
	
	
	

}
