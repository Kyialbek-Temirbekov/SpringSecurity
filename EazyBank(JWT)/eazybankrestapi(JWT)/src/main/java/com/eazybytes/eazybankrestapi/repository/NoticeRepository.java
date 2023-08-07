package com.eazybytes.eazybankrestapi.repository;

import com.eazybytes.eazybankrestapi.model.Notice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
	@Query(value = "from Notice n where current date BETWEEN n.noticBegDt AND n.noticEndDt")
	List<Notice> findAllActiveNotices();

}
