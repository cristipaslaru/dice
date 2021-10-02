package com.assignment.dice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class RollDice {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Column(name="sum_of_dices", nullable = false)
    private Integer sumOfDices;
    @Column(name="occurrence_no", nullable = false)
    private Integer occurrenceNo;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="simulation_id", nullable=false)
    @JsonBackReference
    private Simulation simulation;

    public RollDice() {
    }

    public RollDice(Integer sumOfDices, Integer occurrenceNo, Simulation simulation) {
        this.sumOfDices = sumOfDices;
        this.occurrenceNo = occurrenceNo;
        this.simulation = simulation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSumOfDices() {
        return sumOfDices;
    }

    public void setSumOfDices(Integer sumOfDices) {
        this.sumOfDices = sumOfDices;
    }

    public Integer getOccurrenceNo() {
        return occurrenceNo;
    }

    public void setOccurrenceNo(Integer occurrenceNo) {
        this.occurrenceNo = occurrenceNo;
    }

    public Simulation getSimulation() {
        return simulation;
    }

    public void setSimulation(Simulation simulation) {
        this.simulation = simulation;
    }
}
