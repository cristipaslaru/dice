package com.assignment.dice.dtos;

public class SimulationDTO {

    private Integer noOfDices;
    private Integer noOfSlides;
    private long noOfRolls;
    private long simulationNo;

    public SimulationDTO(Integer noOfDices, Integer noOfSlides, long noOfRolls, long simulationNo) {
        this.noOfDices = noOfDices;
        this.noOfSlides = noOfSlides;
        this.noOfRolls = noOfRolls;
        this.simulationNo = simulationNo;
    }

    public Integer getNoOfDices() {
        return noOfDices;
    }

    public void setNoOfDices(Integer noOfDices) {
        this.noOfDices = noOfDices;
    }

    public Integer getNoOfSlides() {
        return noOfSlides;
    }

    public void setNoOfSlides(Integer noOfSlides) {
        this.noOfSlides = noOfSlides;
    }

    public long getNoOfRolls() {
        return noOfRolls;
    }

    public void setNoOfRolls(long noOfRolls) {
        this.noOfRolls = noOfRolls;
    }

    public long getSimulationNo() {
        return simulationNo;
    }

    public void setSimulationNo(long simulationNo) {
        this.simulationNo = simulationNo;
    }
}
