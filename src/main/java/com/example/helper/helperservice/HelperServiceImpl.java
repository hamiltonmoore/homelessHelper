package com.example.helper.helperservice;

import com.example.helper.helpermodel.Helper;
import com.example.helper.repository.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class HelperServiceImpl implements HelperService {
    @Autowired
    HelperRepository helperRepository;

    @Transactional
    @Override
    public void add(Helper helper) {
        helperRepository.add(helper);
    }

    @Override
    public Helper getById(int id) {
        return helperRepository.getById(id);
    }

    @Override
    public List<Helper> getByContact_Type(String contact_type) {return helperRepository.getByContact_Type(contact_type);}

    @Override
    public List<Helper> get() {
        return helperRepository.get();
    }

    @Transactional
    @Override
    public void update(Helper helper) {
        helperRepository.update(helper);

    }

    @Transactional
    @Override
    public void delete(int id) {
        helperRepository.delete(id);
    }

    public void createTable() {
        helperRepository.createTable();
    }
}
