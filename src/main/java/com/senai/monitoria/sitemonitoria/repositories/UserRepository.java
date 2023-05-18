package com.senai.monitoria.sitemonitoria.repositories;

import com.senai.monitoria.sitemonitoria.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long>, CrudRepository<User, Long> {
}
