package com.maincar.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maincar.model.Carmodel;
import com.maincar.service.CarService;

@Controller
@RequestMapping("/car")
public class CarCantroller {

	@Autowired
	private CarService carService;
	
	@GetMapping("")
	public String getCars(Model model) {
		Iterable<Carmodel> carmodel = this.carService.getAll();
		model.addAttribute("carmodel",carmodel);
		return "list-cars";
	}
	
	@GetMapping("/view")
	public String getbyId(@RequestParam("id") Integer id, Model model) {
		 model.addAttribute("carmodel",this.carService.getById(id));
		 return"view-cars";
	}
	
	@GetMapping("/add")
	public String addCarForm(Model model)
	{
		Carmodel carmodel = new Carmodel();
		model.addAttribute("carmodel",carmodel);
		return "car-form";
	}
	
	@PostMapping("/add")
	public String addCarSubmit(@ModelAttribute("carmodel") Carmodel carmodel)
	{
		this.carService.addFormCar(carmodel);
		return "redirect:";
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, Model model) {
		Carmodel list = carService.getById(id);
		model.addAttribute("carmodel",list);
		return "update-form";
	}
	
	@PostMapping("/update/{id}")
	public String updateSubmit(@PathVariable Integer id, @Valid Carmodel carmodel,Model model) {
		model.addAttribute("carmodel",this.carService.updateCar(id, carmodel));
		return "redirect:/car";
	}
	
	@GetMapping("/remove/{id}")
	public String delet(@PathVariable Integer id) {
		this.carService.carDelet(id);
		return "redirect:/car";
	}
}
