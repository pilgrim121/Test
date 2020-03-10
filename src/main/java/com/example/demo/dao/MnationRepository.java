package com.example.demo.dao;

import com.example.demo.po.Mnation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MnationRepository extends JpaRepository<Mnation,Long> {
}
