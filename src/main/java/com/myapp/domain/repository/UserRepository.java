package com.myapp.domain.repository;

import com.myapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByUserName(String userName);

    @Transactional
    @Modifying
    @Query("Update User u Set u.userEmail = :email Where u.userId = :id")
    void changeEmailAddress(@Param("email") String email, @Param("id") int id);

    @Transactional
    @Modifying
    @Query("Update User u Set u.phoneNumber = :phoneNumber Where u.userId = :id")
    void changePhoneNumber(@Param("phoneNumber") String phoneNumber, @Param("id") Integer id);

}
