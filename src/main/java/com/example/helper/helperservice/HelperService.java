package com.example.helper.helperservice;

import com.example.helper.helpermodel.Helper;

import java.util.List;

public interface HelperService {
    void add(Helper helper);
    Helper getById(int id);
    List<Helper> getByContact_Type(String contact_type);
    List<Helper> get();
    void update(Helper customer);
    void createTable();
    void delete(int id);
}
