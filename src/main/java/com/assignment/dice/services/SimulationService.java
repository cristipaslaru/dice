package com.assignment.dice.services;

import com.assignment.dice.dtos.DistributionDTO;
import com.assignment.dice.dtos.SimulationDTO;
import com.assignment.dice.entity.Simulation;

import java.util.Set;

public interface SimulationService {
    Simulation saveSimulation(Integer noOfRolls, Integer noOfDices, Integer noOfSlides);
    Set<SimulationDTO> getSimulationDetails();
    Set<DistributionDTO> getRelativeDistribution(Integer noOfDices, Integer noOfSlides);
}
