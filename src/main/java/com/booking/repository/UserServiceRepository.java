package com.booking.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.beans.User;

@Repository
public interface UserServiceRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from userinfo where MOBILE_NMBER=:mobilenumber and password=:password", nativeQuery = true)
	public Optional<User> logIn(@Param("mobilenumber") long mobilenumber, @Param("password") String password);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query(value = "UPDATE userinfo SET PASSWORD =:newPassword  WHERE PASSWORD =:oldPassword ", nativeQuery = true)
	void changePassword(@Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword);

	public Optional<User> findBymobileNmber(long mobilenumber);

	public Optional<User> findBypassword(String mobilenumber);

}