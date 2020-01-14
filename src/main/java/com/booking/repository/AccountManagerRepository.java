package com.booking.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.beans.UserLoginBean;
import com.booking.beans.LoginResponseBean;

@Repository
public interface AccountManagerRepository extends JpaRepository<UserLoginBean, Long> {

	@Query(value = "select * from USER_LOGIN where PASSWORD=:password and EMAIL_ID=:emailId", nativeQuery = true)
	public Optional<UserLoginBean> logIn(@Param("password") String password,
			@Param("emailId") String emailId);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE USER_LOGIN SET PASSWORD =:newPassword  WHERE PASSWORD =:oldPassword ", nativeQuery = true)
	void changePassword(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

	public UserLoginBean findBymobileNumber(long mobilenumber);

	public UserLoginBean findBypassword(String mobilenumber);

	public UserLoginBean findByemailId(String emailId);

}