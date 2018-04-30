package com.cafe24.guestbook.repository2;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cafe24.guestbook.domain.Guestbook;

public interface GuestbookRepository2 extends JpaRepository<Guestbook, Long> {

	// 쿼리 메서드 생성 방법 4가지
	// 1. JPA Repository Interface Method
	// 2. 메서드 이름으로 생성
	// 3. @Query
	// 4. JPA Named Query

	List<Guestbook> findAllByOrderByRegDateDesc();

}
