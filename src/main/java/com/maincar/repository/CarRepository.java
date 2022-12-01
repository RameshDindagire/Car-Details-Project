package com.maincar.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.maincar.model.Carmodel;

@Repository
public interface CarRepository extends CrudRepository<Carmodel, Integer>{

}
