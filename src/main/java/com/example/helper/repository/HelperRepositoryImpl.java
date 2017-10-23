package com.example.helper.repository;

import com.example.helper.helpermodel.Helper;
import org.springframework.stereotype.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class HelperRepositoryImpl implements HelperRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String CREATE_SQL = "CREATE TABLE IF NOT EXISTS helper (id serial not null, contact text, contact_type text, " +
            "longitude double precision, latitude double precision, location_1_address text, location_1_city text, location_1_state text, " +
            "notes text, phone_number text, constraint helper_pkey primary key (id));";

    public void createTable() {
        System.out.println(" +*+*+*+* creating table: ");
        jdbcTemplate.execute(CREATE_SQL);
    }

    private final String INSERT_SQL = "INSERT INTO helper (contact, contact_type, longitude, latitude, " +
            "location_1_address, location_1_city, location_1_state, notes, phone_number) VALUES (?,?,?,?,?,?,?,?,?)";

    @Override
    public void add(Helper helper) {
        System.out.println("*** helper = " + helper.toString());
        jdbcTemplate.update(INSERT_SQL, helper.getContact(), helper.getContact_type(), helper.getLongitude(),
                helper.getLatitude(), helper.getLocation_1_address(), helper.getLocation_1_city(),
                helper.getLocation_1_state(), helper.getNotes(), helper.getPhone_number());
    }

    @Override
    public Helper getById(int id) {
        return jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new HelperMapper(), id);
    }

    private final String SELECT_BY_ID_SQL = "SELECT * FROM helper WHERE id = ?";

//
    @Override
    public List<Helper> getByContact_Type(String contact_type) {return jdbcTemplate.query(SELECT_SQL, new HelperMapper(), contact_type);}

    private final String SELECT_SQL = "SELECT * FROM helper WHERE contact_type = ?";

    @Override
    public List<Helper> get() {
        return jdbcTemplate.query(GET_SQL, new HelperMapper());
    }

    private final String GET_SQL = "SELECT * FROM helper";

    @Override
    public void update(Helper helper, int id) {
        jdbcTemplate.update(UPDATE_SQL, helper.getContact(), helper.getContact_type(), helper.getLatitude(),
                helper.getLongitude(), helper.getLocation_1_address(), helper.getLocation_1_city(),
                helper.getLocation_1_state(), helper.getNotes(), helper.getPhone_number(), id);
    }

    private final String UPDATE_SQL = "UPDATE helper SET contact=?, contact_type=?, longitude=?, latitude=?, " +
            "location_1_address=?, location_1_city=?, location_1_state=?, notes=?, phone_number=? WHERE id=?"
            ;

    @Override
    public void delete(int id) {
        jdbcTemplate.update(DELETE_SQL, id);
    }

    private final String DELETE_SQL = "DELETE FROM helper WHERE id=?";


    // Map a row of the result set to a person object
    private static class HelperMapper implements RowMapper<Helper> {
        @Override
        public Helper mapRow(ResultSet rs, int rowNum) throws SQLException {
            Helper helper = new Helper();
            helper.setContact(rs.getString("contact"));
            helper.setContact_type(rs.getString("contact_type"));
            helper.setLongitude(rs.getDouble("longitude"));
            helper.setLatitude(rs.getDouble("latitude"));
            helper.setLocation_1_address(rs.getString("location_1_address"));
            helper.setLocation_1_city(rs.getString("location_1_city"));
            helper.setLocation_1_state(rs.getString("location_1_state"));
            helper.setNotes(rs.getString("notes"));
            helper.setPhone_number(rs.getString("phone_number"));
            return helper;
        }

    }

}