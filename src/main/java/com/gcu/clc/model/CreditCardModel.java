package com.gcu.clc.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreditCardModel {

    @NotNull(message="Credit Card Number is a required field")
    @Size(min=16, message="Street must be between 16 characters")
    @ApiModelProperty(value = "Credit Card Number", example = "4111111111111111")
    private String ccNumber;
    @NotNull(message="Expiration Month is a required field")
    @Size(min=2, message="Expiration Month must be 2 characters. IE May == 05")
    @ApiModelProperty(value = "Expiration Month", example = "05")
    private String ccExpMonth;
    @NotNull(message="Expiration Year is a required field")
    @Size(min=4, message="Expiration Year must be 4 characters")
    @ApiModelProperty(value = "Expiration Year", example = "2025")
    private String ccExpYear;
    @NotNull(message="CID is a required field")
    @Size(min=3, message="CID must be 3 characters")
    @ApiModelProperty(value = "CID", example = "111")
    private String ccCID;
    @NotNull(message="Name on card is a required field")
    @Size(min=1, max=32, message="Name on card must be between 1 and 32 characters")
    @ApiModelProperty(value = "Name on card", example = "Bob Smith")
    private String ccNameHolder;

    public CreditCardModel(String ccNumber, String ccExpMonth, String ccExpYear, String ccCID, String ccNameHolder) {
        this.ccNumber = ccNumber;
        this.ccExpMonth = ccExpMonth;
        this.ccExpYear = ccExpYear;
        this.ccCID = ccCID;
        this.ccNameHolder = ccNameHolder;
    }

    public CreditCardModel() {
    }

    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    public String getCcExpMonth() {
        return ccExpMonth;
    }

    public void setCcExpMonth(String ccExpMonth) {
        this.ccExpMonth = ccExpMonth;
    }

    public String getCcExpYear() {
        return ccExpYear;
    }

    public void setCcExpYear(String ccExpYear) {
        this.ccExpYear = ccExpYear;
    }

    public String getCcCID() {
        return ccCID;
    }

    public void setCcCID(String ccCID) {
        this.ccCID = ccCID;
    }

    public String getCcNameHolder() {
        return ccNameHolder;
    }

    public void setCcNameHolder(String ccNameHolder) {
        this.ccNameHolder = ccNameHolder;
    }
}
