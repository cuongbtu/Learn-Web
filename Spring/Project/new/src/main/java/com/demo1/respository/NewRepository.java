package com.demo1.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo1.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long>{

}
