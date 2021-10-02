package com.assignment.dice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Simulation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="simulation_no", nullable = false)
    private Integer simulationNo;
    @Column(name="no_of_rolls", nullable = false)
    private Integer noOfRolls;
    @Column(name="no_of_dices", nullable = false)
    private Integer noOfDices;
    @Column(name="no_of_slides", nullable = false)
    private Integer noOfSlides;
    @OneToMany(mappedBy = "simulation")
    @JsonManagedReference
    private Set<RollDice> rolls;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSimulationNo() {
        return simulationNo;
    }

    public void setSimulationNo(Integer simulationNo) {
        this.simulationNo = simulationNo;
    }

    public Integer getNoOfRolls() {
        return noOfRolls;
    }

    public void setNoOfRolls(Integer noOfRolls) {
        this.noOfRolls = noOfRolls;
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

    public Set<RollDice> getRolls() {
        return rolls;
    }

    public void setRolls(Set<RollDice> rolls) {
        this.rolls = rolls;
    }

    @Override
    public String toString() {
        return "Simulation{" +
                "id=" + id +
                ", simulationNo=" + simulationNo +
                ", noOfRolls=" + noOfRolls +
                ", noOfDices=" + noOfDices +
                ", noOfSlides=" + noOfSlides +
                ", rolls=" + rolls +
                '}';
    }
}
