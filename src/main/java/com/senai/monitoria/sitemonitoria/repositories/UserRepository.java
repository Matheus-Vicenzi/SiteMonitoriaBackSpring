package com.senai.monitoria.sitemonitoria.repositories;

import com.senai.monitoria.sitemonitoria.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.isActive = true")
    List<User> findActiveUsers();
}
