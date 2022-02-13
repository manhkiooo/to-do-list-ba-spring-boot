package com.manhpv.repostory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.manhpv.entity.WorkEntity;
@Repository
public interface WorkRepository extends JpaRepository<WorkEntity, Long> {
	/*
	 * @Query(value="SELECT u FROM WorkEntity u WHERE u.workName LIKE ?1")
	 * List<WorkEntity> findByFirstName(String firstName);
	 */
}
