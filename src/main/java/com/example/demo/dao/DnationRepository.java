package com.example.demo.dao;

import com.example.demo.po.Dnation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnationRepository extends JpaRepository<Dnation,Long> {
}
