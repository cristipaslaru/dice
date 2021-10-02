package com.assignment.dice.services;

import com.assignment.dice.dtos.SimulationDTO;
import com.assignment.dice.entity.Simulation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.util.Objects;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimulationServiceTest {

    @Autowired
    private SimulationService simulationService;

    @Test
    public void saveSimulationTest(){
        Simulation simulation = saveSimulation(3,3,5);
        Assert.assertNotNull(simulation);
        Assert.assertEquals(Integer.valueOf(1),simulation.getSimulationNo());
        Assert.assertEquals(Integer.valueOf(3),simulation.getNoOfRolls());
        Assert.assertEquals(Integer.valueOf(5),simulation.getNoOfSlides());
        Assert.assertEquals(Integer.valueOf(3),simulation.getNoOfDices());
    }

    @Test
    public void getSimulationDetailsTest(){
        Simulation simulation = saveSimulation(3,3,5);
        Assert.assertNotNull(simulation);
        Set<SimulationDTO> simDetails = simulationService.getSimulationDetails();
        Assert.assertNotNull(simDetails);
        Assert.assertEquals(1,simDetails.size());
        Assert.assertEquals(3, Objects.requireNonNull(simDetails.stream().findFirst().orElse(null)).getNoOfRolls());
        simulation = saveSimulation(3,3,5);
        Assert.assertNotNull(simulation);
        simDetails = simulationService.getSimulationDetails();
        Assert.assertEquals(1,simDetails.size());
        Assert.assertEquals(6, Objects.requireNonNull(simDetails.stream().findFirst().orElse(null)).getNoOfRolls());

        simulation = saveSimulation(3,2,5);
        Assert.assertNotNull(simulation);
        simDetails = simulationService.getSimulationDetails();
        Assert.assertEquals(2,simDetails.size());
    }

    private Simulation saveSimulation(Integer noOfRolls, Integer noOfDices, Integer noOfSlides){
        return simulationService.saveSimulation(noOfRolls,noOfDices,noOfSlides);
    }
}
