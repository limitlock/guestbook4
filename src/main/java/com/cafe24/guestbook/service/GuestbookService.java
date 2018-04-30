package com.cafe24.guestbook.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafe24.guestbook.domain.Guestbook;
import com.cafe24.guestbook.repository2.GuestbookRepository2;

@Service
@Transactional
public class GuestbookService {

	@Autowired
	private GuestbookRepository2 guestbookRepository;

	public List<Guestbook> getMessageList() {
		return guestbookRepository.findAllByOrderByRegDateDesc();

	}

	public void insertMessage(Guestbook guestbook) {
		guestbook.setRegDate(new Date());
		guestbookRepository.save(guestbook);

	}

	public void deleteMessage(Guestbook guestbook) {
		guestbookRepository.delete(guestbook);

	}
}
