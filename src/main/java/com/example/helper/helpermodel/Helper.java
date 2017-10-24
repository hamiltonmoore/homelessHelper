package com.example.helper.helpermodel;

import java.lang.reflect.Field;

// Database model
public class Helper {
    String id;
    String contact;
    String contact_type;    // TODO: convert to Java naming convention
    Double longitude;
    Double latitude;
    String location_1_address;
    String location_1_city;
    String location_1_state;
    String notes;
    String phone_number;

//    @Override
//    public String toString() {
//        return String.format("contact = %s, contact_type = %s"
//        ,contact
//        ,contact_type);
//    }



    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        String newLine = System.getProperty("line.separator");

        result.append( this.getClass().getName() );
        result.append( " Object {" );
        result.append(newLine);

        //determine fields declared in this class only (no fields of superclass)
        Field[] fields = this.getClass().getDeclaredFields();

        //print field names paired with their values
        for ( Field field : fields  ) {
            result.append("  ");
            try {
                result.append( field.getName() );
                result.append(": ");
                //requires access to private field:
                result.append( field.get(this) );
            } catch ( IllegalAccessException ex ) {
                System.out.println(ex);
            }
            result.append(newLine);
        }
        result.append("}");

        return result.toString();
    }

    public String getContact() {
        return contact;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public String getLocation_1_address() {
        return location_1_address;
    }

    public void setLocation_1_address(String location_1_address) {
        this.location_1_address = location_1_address;
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

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }
}
