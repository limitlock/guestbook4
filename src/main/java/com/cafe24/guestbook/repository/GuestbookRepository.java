package com.cafe24.guestbook.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cafe24.guestbook.domain.Guestbook;

@Repository
public class GuestbookRepository {

	@PersistenceContext // Factory 가 인식(DI)할 수 있게끔 한다.
	private EntityManager em;

	public List<Guestbook> findAll() {
		String jpql = "select gb from Guestbook gb order by gb.regDate desc";
		TypedQuery<Guestbook> query = em.createQuery(jpql, Guestbook.class);

		return query.getResultList();

	}

	public void save(Guestbook guestbook) {
		guestbook.setRegDate(new Date());
		em.persist(guestbook);
	}

	public boolean remove(Guestbook guestbook) {
		String jpql = "select gb from Guestbook gb where gb.no = :no and gb.password = :password";
		TypedQuery<Guestbook> query = em.createQuery(jpql, Guestbook.class);
		query.setParameter("no", guestbook.getNo());
		query.setParameter("password", guestbook.getPassword());

		// 결과과 잘못되면 error handle 때문에 쓰지 않는다.
		// Guestbook result = query.getSingleResult();

		List<Guestbook> list = query.getResultList();
		if (list.size() != 1) {
			return false;
		}

		em.remove(list.get(0));
		return true;
	}
}
