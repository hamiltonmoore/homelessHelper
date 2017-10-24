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
    String contact_type;
    Location location_1;    // TODO: convert all to Java proper names
    String location_1_Address;
    String location_1_city;
    String location_1_state;
    String notes;
    String phone_number;

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getContact_type() {
        return contact_type;
    }

    public void setContact_type(String contact_type) {
        this.contact_type = contact_type;
    }

    public Location getLocation_1() {
        return location_1;
    }

    public void setLocation_1(Location location_1) {
        this.location_1 = location_1;
    }

    public String getLocation_1_Address() {
        return location_1_Address;
    }

    public void setLocation_1_Address(String location_1_Address) {
        this.location_1_Address = location_1_Address;
    }

    public String getLocation_1_city() {
        return location_1_city;
    }

    public void setLocation_1_city(String location_1_city) {
        this.location_1_city = location_1_city;
    }

    public String getLocation_1_state() {
        return location_1_state;
    }

    public void setLocation_1_state(String location_1_state) {
        this.location_1_state = location_1_state;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getphone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
