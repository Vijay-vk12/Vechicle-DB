package com.example.vehiclemanagent.ServiceImple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vehiclemanagent.Exception.VehicleNotFoundException;
import com.example.vehiclemanagent.Repository.VehicleRepository;
import com.example.vehiclemanagent.Service.VehicleService;
import com.example.vehiclemanagent.model.Vehicle;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vrepo;
	@Override
	public Vehicle addVehicle(Vehicle vehicle) {
		
		return vrepo.save(vehicle);
	}

	@Override
	public void deleteVehicleById(Long vid) {
		vrepo.deleteById(vid);
		
	}

	@Override
	public Vehicle updateVehicle(Long vid, Vehicle vehicle) {
		  Vehicle ev = vrepo.findById(vid)
		            .orElseThrow(() -> new VehicleNotFoundException("Vehicle not found with id: " + vid));
		        ev.setVname(vehicle.getVname());
		        ev.setVprice(vehicle.getVprice());
		        ev.setVmodel(vehicle.getVmodel());
		        ev.setVcolor(vehicle.getVcolor());
		        return vrepo.save(ev);
	
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		
		return vrepo.findAll();
	}

	@Override
	public Vehicle getVehicleById(Long vid) {
		
		return vrepo.findById(vid).orElseThrow(() -> new VehicleNotFoundException (" Vehicle Not Found with Id : "+vid));
	}

	 public List<Vehicle> getVehiclesByPriceGreaterThan(double vprice) {
	        return vrepo.findByVpriceGreaterThan10k(vprice);
	    }
	    
	    public List<Vehicle> getVehiclesByPriceAscColorAsc() {
	        return vrepo.findByOrderByVpriceAscVcolorAsc();
	    }

		@Override
		public List<Vehicle> getVehicleByColor(String col) {
			
			return vrepo.findByVcolor(col);
		}
	    
	   
	   
	

}
