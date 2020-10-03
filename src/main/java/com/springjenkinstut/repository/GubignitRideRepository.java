package com.springjenkinstut.repository;

import com.springjenkinstut.entity.GubignitParkRide;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GubignitRideRepository extends JpaRepository<GubignitParkRide, Long> {

    List<GubignitParkRide> findByName(String name);
}
