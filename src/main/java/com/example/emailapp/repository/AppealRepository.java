package com.example.emailapp.repository;

import com.example.emailapp.entity.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppealRepository extends JpaRepository<Appeal, Long> {
}
