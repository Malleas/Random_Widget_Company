package com.gcu.clc.data;

import com.gcu.clc.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AddressDataService implements DataAccessInterface<AddressModel> {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public AddressDataService(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getAddressIdByUserId(int userId){
        String sql = "SELECT ADDRESS_ID FROM ADDRESS WHERE IS_CURRENT = 1 && ADDRESS.USER_ID = ? ORDER BY ADDRESS_ID DESC LIMIT 1 ";
        int addressId = 0;
        try {
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, userId);
            while (srs.next()){
                addressId = srs.getInt("ADDRESS_ID");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return addressId;
    }

    @Override
    public List<AddressModel> getAll() {
        String sql = "SELECT * FROM ADDRESS";
        List<AddressModel> addresses = new ArrayList<>();
        try{
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql);
            while (srs.next()){
                addresses.add(new AddressModel(srs.getInt("ADDRESS_ID"),
                        srs.getInt("USER_ID"),
                        srs.getString("STREET"),
                        srs.getString("CITY"),
                        srs.getString("STATE_ABBREVIATION"),
                        srs.getString("ZIPCODE"),
                        srs.getBoolean("IS_CURRENT")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public AddressModel getById(int id) {
        String sql = "SELECT * FROM ADDRESS WHERE ADDRESS_ID = ?";
        AddressModel address = new AddressModel();
        try{
            SqlRowSet srs = jdbcTemplate.queryForRowSet(sql, id);
            while (srs.next()){
                address.setAddressId(srs.getInt("ADDRESS_ID"));
                address.setUserId(srs.getInt("USER_ID"));
                address.setStreet(srs.getString("STREET"));
                address.setCity(srs.getString("CITY"));
                address.setStateAbbreviation(srs.getString("STATE_ABBREVIATION"));
                address.setZipcode(srs.getString("ZEIPCODE"));
                address.setCurrent(srs.getBoolean("IS_CURRENT"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public boolean create(AddressModel addressModel) {
        String sql = "INSERT INTO ADDRESS(USER_ID, STREET, CITY, STATE_ABBREVIATION, ZIPCODE) VALUES(?,?,?,?,?)";
        try {
            jdbcTemplate.update(sql, addressModel.getUserId(), addressModel.getStreet(), addressModel.getCity(), addressModel.getStateAbbreviation(),
                    addressModel.getZipcode());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean update(AddressModel addressModel) {
        String sql = "UPDATE ADDRESS SET STREET = ?, CITY = ?, STATE_ABBREVIATION = ?, ZIPCODE = ?, IS_CURRENT = ? WHERE ADDRESS_ID = ?";
        try {
            jdbcTemplate.update(sql, addressModel.getStreet(), addressModel.getCity(), addressModel.getStateAbbreviation(),
                    addressModel.getZipcode(), addressModel.getAddressId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(AddressModel addressModel) {
        String sql = "DELETE FROM ADDRESS WHERE ADDRESS_ID = ?";
        try {
            jdbcTemplate.update(sql, addressModel.getAddressId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
