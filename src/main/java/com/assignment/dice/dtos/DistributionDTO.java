package com.assignment.dice.dtos;

import java.text.DecimalFormat;

public class DistributionDTO {

    private Integer sumOfDices;
    private String distributionValue;
    private long noOfRolls;
    private long occurrenceNo;

    public DistributionDTO(Integer sumOfDices, long noOfRolls, long occurrenceNo) {
        this.sumOfDices = sumOfDices;
        this.noOfRolls = noOfRolls;
        this.occurrenceNo = occurrenceNo;
        calculateDistributionValue((double)occurrenceNo,(double) noOfRolls);
    }

    private void calculateDistributionValue(double occurrenceNo, double rolls){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        this.distributionValue = decimalFormat.format(occurrenceNo * 100 / rolls);
    }

    public Integer getSumOfDices() {
        return sumOfDices;
    }

    public String getDistributionValue() {
        return distributionValue;
    }

    public long getNoOfRolls() {
        return noOfRolls;
    }

    public long getOccurrenceNo() {
        return occurrenceNo;
    }
}
