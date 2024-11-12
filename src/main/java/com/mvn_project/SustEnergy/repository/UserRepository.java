package com.mvn_project.SustEnergy.repository;

import com.mvn_project.SustEnergy.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
