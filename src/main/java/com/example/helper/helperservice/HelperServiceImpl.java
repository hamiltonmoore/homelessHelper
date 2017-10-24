package com.example.helper.helperservice;

import com.example.helper.helpermodel.Helper;
import com.example.helper.repository.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
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
    public List<Helper> getByContactType(String contactType) {return helperRepository.getByContactType(contactType);}

    @Override
    public List<Helper> get() {
        return helperRepository.get();
    }

    @Override
    public int count() {
        return helperRepository.count();
    }

    @Transactional
    @Override
    public void update(Helper helper, int id) {
        helperRepository.update(helper, id);

    }

    @Transactional
    @Override
    public void delete(int id) {
        helperRepository.delete(id);
    }

    @Transactional
    @Override
    public int deleteAll() {
       return helperRepository.deleteAll();
    }


    public void createTable() {
        helperRepository.createTable();
    }
}
