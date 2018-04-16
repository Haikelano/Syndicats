package com.syndicat.syndicats.dao;

import com.syndicat.syndicats.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>{
}
