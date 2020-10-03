package com.springjenkinstut.controller;

import com.springjenkinstut.entity.GubignitParkRide;
import com.springjenkinstut.repository.GubignitRideRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class GubignitApi {

    private final GubignitRideRepository gubignitRideRepository;

    public GubignitApi(GubignitRideRepository gubignitRideRepository) {
        this.gubignitRideRepository = gubignitRideRepository;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/ride", consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public GubignitParkRide createRide(@RequestBody GubignitParkRide gParkRide) {
        return gubignitRideRepository.save(gParkRide);
    }

    @GetMapping(value = "/rides", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<GubignitParkRide> fetchAll() {
        return gubignitRideRepository.findAll();
    }

    @GetMapping(value = "/ride/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GubignitParkRide fetchOne(@PathVariable Long id) {
        return gubignitRideRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
