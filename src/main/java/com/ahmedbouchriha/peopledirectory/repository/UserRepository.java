package com.ahmedbouchriha.peopledirectory.repository;

import com.ahmedbouchriha.peopledirectory.domain.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  public User findByUsername(String username);

}
