package com.gcu.clc.business;

import com.gcu.clc.data.AddressDataService;
import com.gcu.clc.model.AddressModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBusinessService {

    @Autowired
    private AddressDataService addressDataService;

    public boolean addAddress(AddressModel addressModel){
        return addressDataService.create(addressModel);
    }

    public List<AddressModel> getAll() {
        return addressDataService.getAll();
    }

    public AddressModel getById(Integer addressId){
        return addressDataService.getById(addressId);
    }

    public boolean updateAddress(AddressModel addressModel){
        return addressDataService.update(addressModel);
    }

    public boolean deleteAddress(AddressModel addressModel){
        return addressDataService.delete(addressModel);
    }

    public int getAddressIdByUserId(int userId){
        return addressDataService.getAddressIdByUserId(userId);
    }
}
