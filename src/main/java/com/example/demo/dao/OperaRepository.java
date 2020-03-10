package com.example.demo.dao;

import com.example.demo.po.Odata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperaRepository extends JpaRepository<Odata,Long> {
}
