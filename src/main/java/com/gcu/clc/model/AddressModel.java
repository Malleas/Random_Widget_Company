package com.gcu.clc.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AddressModel {
    @ApiModelProperty(value = "Address ID", example = "1")
    private int addressId;
    @ApiModelProperty(value = "User ID from USER table", example = "1")
    private int userId;
    @NotNull(message="Street is a required field")
    @Size(min=1, max=32, message="Street must be between 1 and 32 characters")
    @ApiModelProperty(value = "Street address", example = "123 Hill St.")
    private String street;
    @NotNull(message="City is a required field")
    @Size(min=1, max=32, message="City must be between 1 and 32 characters")
    @ApiModelProperty(value = "City", example = "Nashville")
    private String city;
    @NotNull(message="State Abbreviation is a required field")
    @Size(min=2, message="State Abbreviation must be between 1 and 32 characters")
    @ApiModelProperty(value = "State recognized 2 character abbreviation", example = "TN")
    private String stateAbbreviation ;
    @NotNull(message="Zipcode is a required field")
    @Size(min=5, max=9, message="Zipcode must be between at least 5 characters long")
    @ApiModelProperty(value = "5 or 9 digit postal code", example = "37214 or 37214-0001")
    private String zipcode;
    @ApiModelProperty(value = "Flag used to indicate if address is current.  User may have multiple addresses.", example = "1")
    private boolean isCurrent;


    public AddressModel(int userId, String street, String city, String stateAbbreviation, String zipcode, boolean isCurrent) {
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.stateAbbreviation = stateAbbreviation;
        this.zipcode = zipcode;
        this.isCurrent = isCurrent;
    }

    public AddressModel(int addressId, int userId, String street, String city, String stateAbbreviation, String zipcode, boolean isCurrent) {
        this.addressId = addressId;
        this.userId = userId;
        this.street = street;
        this.city = city;
        this.stateAbbreviation = stateAbbreviation;
        this.zipcode = zipcode;
        this.isCurrent = isCurrent;
    }

    public AddressModel() {}

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }
}
