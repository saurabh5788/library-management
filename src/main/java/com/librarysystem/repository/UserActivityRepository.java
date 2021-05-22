package com.librarysystem.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.librarysystem.entities.UserActivityLog;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivityLog, Integer> {
	
	@Modifying
	@Query("update userActivityLog ual set ual.user_id=?1 ual.charge=?2 ual.returnDate=?3 where ual.logId=?4")
	boolean updateUserActivityLogsForBookReturn(@Param ("user_id") int userid, 
			@Param ("charge") double chargeForLateReturn,@Param("return_date") LocalDate currentDate, @Param("log_id") int logId);
	
}
