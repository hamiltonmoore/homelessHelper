package com.example.helper.repository;

import com.example.helper.helpermodel.Helper;

import java.util.List;

public interface HelperRepository {
    void add(Helper helper);
    Helper getById(int id);
    List<Helper> getByContact_Type(String contact_type);
    List<Helper> get();
    void update(Helper customer, int id);
    void createTable();
    void delete(int id);
}
