package com.example.vehiclemanagent.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.vehiclemanagent.model.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

	@Query("select * from Vehicle where vcolor=?1")
	List<Vehicle> findByVcolor(String vcolor);
	@Query("select * from Vehicle where vprice>?1")
	List<Vehicle> findByVpriceGreaterThan10k(double vprice);
	@Query("select * from Vehicle orderBy vprice asc")
	List<Vehicle> findByOrderByVpriceAscVcolorAsc();
}
