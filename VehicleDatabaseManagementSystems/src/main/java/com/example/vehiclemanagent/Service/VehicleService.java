package com.example.vehiclemanagent.Service;

import java.util.List;

import com.example.vehiclemanagent.model.Vehicle;

public interface VehicleService {

	Vehicle addVehicle(Vehicle vehicle);
	
	public void deleteVehicleById(Long vid) ;
	Vehicle updateVehicle(Long vid, Vehicle vehicle);
	List<Vehicle> getAllVehicles();
	Vehicle getVehicleById(Long vid);
	List<Vehicle> getVehicleByColor(String col);
	List<Vehicle> getVehiclesByPriceGreaterThan(double vprice);
	List<Vehicle> getVehiclesByPriceAscColorAsc();
	
}
