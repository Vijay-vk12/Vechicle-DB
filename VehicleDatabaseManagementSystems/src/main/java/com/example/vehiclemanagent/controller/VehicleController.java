package com.example.vehiclemanagent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vehiclemanagent.Service.VehicleService;
import com.example.vehiclemanagent.model.Vehicle;

//localhost:8080
@RestController
public class VehicleController {

	@Autowired
   private VehicleService vehicleService;
	
	//localhost:8080/getAll
	
    @GetMapping("/getAll")
     List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }
  //localhost:8080/getById
    
    @GetMapping("/getvById")
    public Vehicle getVehicleById(@RequestHeader Long vid) {
        return vehicleService.getVehicleById(vid);
    }
    
  //localhost:8080/getByColor
    
    @GetMapping("/getByColor")
    public List<Vehicle> getVehiclesByColor(@RequestHeader String vcolor) {
        return vehicleService.getVehicleByColor(vcolor);
    }
    
  //localhost:8080/getByPrice
    
    @GetMapping("/getByPrice")
    public List<Vehicle> getVehiclesByPriceGreaterThan(@RequestHeader double vprice) {
        return vehicleService.getVehiclesByPriceGreaterThan(vprice);
    }
    
  //localhost:8080/sorted
    
    @GetMapping("/sorted")
    public List<Vehicle> getVehiclesByPriceAscColorAsc() {
        return vehicleService.getVehiclesByPriceAscColorAsc();
    }
    
  //localhost:8080/add
    
    @PostMapping("/add")
    public Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }
    
  //localhost:8080/deleteById
    
    @DeleteMapping("/deleteById")
    public void deleteVehicleById(@RequestHeader Long vid) {
        vehicleService.deleteVehicleById(vid);
    }
    
  //localhost:8080/update
    
    @PutMapping("/update")
    public Vehicle updateVehicle(@PathVariable Long vid, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(vid, vehicle);
    }
}
