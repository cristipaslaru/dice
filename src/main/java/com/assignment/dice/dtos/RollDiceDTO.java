package com.assignment.dice.dtos;

public class RollDiceDTO {

    private Integer sumOfDices;
    private Integer occurrenceNo;

    public RollDiceDTO(Integer sumOfDices, Integer occurrenceNo) {
        this.sumOfDices = sumOfDices;
        this.occurrenceNo = occurrenceNo;
    }

    public Integer getSumOfDices() {
        return sumOfDices;
    }

    public Integer getOccurrenceNo() {
        return occurrenceNo;
    }
}
