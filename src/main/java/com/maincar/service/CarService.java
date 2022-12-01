package com.maincar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.maincar.model.Carmodel;
import com.maincar.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository carRepository;
	
	public Iterable<Carmodel> getAll() {
		return this.carRepository.findAll();
	}
	
	public Carmodel getById(Integer id) {
		return this.carRepository.findById(id).orElseThrow(
				()->{throw new ResponseStatusException(HttpStatus.NOT_FOUND);
				});
		
	}
	
	public Carmodel addFormCar(Carmodel carmodel) {
		return this.carRepository.save(carmodel);
	}
	
	public Carmodel updateCar(Integer id ,Carmodel carmodel) {
		this.getById(id);
		carmodel.setId(id);
		return this.carRepository.save(carmodel);
	}
	
	public void carDelet(Integer id) {
		this.carRepository.deleteById(id);
	
	}
}
