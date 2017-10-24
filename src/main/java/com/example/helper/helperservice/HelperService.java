package com.example.helper.helperservice;

import com.example.helper.helpermodel.Helper;
import org.springframework.stereotype.Service;

import java.util.List;

public interface HelperService {
    void add(Helper helper);
    Helper getById(int id);
    List<Helper> getByContact_type(String contact_type);
    List<Helper> get();
    void update(Helper customer, int id );
    void createTable();
    void delete(int id);
    int deleteAll();
    int count();
}
