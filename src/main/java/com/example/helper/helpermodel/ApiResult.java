package com.example.helper.helpermodel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/*
"contact":"Hermitage Hall",
"contact_type":"Teen Services",
"location_1":{"type":"Point","coordinates":[-86.778433,36.139821]},
"location1Address":"1220 8th Ave. S.",
"location_1_city":"Nashville",
"location_1_state":"TN",
"notes":"residential treatment for teens suffering from trauma",
"phone_number":"615-742-3000"
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResult {
    String contact;
    @JsonProperty("contact_type")
    String contactType;
    Location location_1;    // TODO: convert all to Java proper names
    @JsonProperty("location_1_address")
    String location1Address;
    @JsonProperty("location_1_city")
    String location1city;
    @JsonProperty("location_1_state")
    String location_1_state;
    String notes;
    @JsonProperty("phone_number")
    String phone_number;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public Location getLocation_1() {
        return location_1;
    }

    public void setLocation_1(Location location_1) {
        this.location_1 = location_1;
    }

    public String getLocation1Address() {
        return location1Address;
    }

    public void setLocation1Address(String location1Address) {
        this.location1Address = location1Address;
    }

    public String getLocation1city() {
        return location1city;
    }

    public void setLocation_1_city(String location1city) {
        this.location1city = location1city;
    }

    public String getLocation1state() {
        return location_1_state;
    }

    public void setLocation1state(String location1state) {
        this.location_1_state = location1state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getphoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_number = phoneNumber;
    }
}
