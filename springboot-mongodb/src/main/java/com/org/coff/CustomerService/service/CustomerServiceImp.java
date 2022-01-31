package com.org.coff.CustomerService.service;

import com.org.coff.CustomerService.model.CustomerModel;
import com.org.coff.CustomerService.reposirory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerServiceInt{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public String create(CustomerModel customerModel) {
        customerRepository.save(customerModel);
        return "created succesfully";
    }

    @Override
    public List<CustomerModel> retriveAll() {
        return customerRepository.findAll();
    }

    @Override
    public CustomerModel retriveById(Integer sno) {

        return customerRepository.findById(sno).orElse(null);
    }

    @Override
    public ResponseEntity<CustomerModel> retriv(Integer sno) {
        try {
         return new ResponseEntity<CustomerModel>(customerRepository.findById(sno).orElse(null),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public CustomerModel updte(CustomerModel customerModel) {
      CustomerModel cus=customerRepository.findById(customerModel.getSno()).orElse(null);

      cus.setName(customerModel.getName());
      cus.setAddress(customerModel.getAddress());

        return customerRepository.save(cus);
    }

    @Override
    public ResponseEntity<CustomerModel> updteRe(CustomerModel customerModel) {
        try {


            CustomerModel cus = customerRepository.findById(customerModel.getSno()).orElse(null);

            cus.setName(customerModel.getName());
            cus.setAddress(customerModel.getAddress());
            return new ResponseEntity<CustomerModel>(customerRepository.save(cus),HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public CustomerModel updatePa(Integer sno, String adress) {
        CustomerModel cus=customerRepository.findById(sno).orElse(null);
        cus.setAddress(adress);

        return customerRepository.save(cus);
    }

    @Override
    public ResponseEntity<CustomerModel> updatePar(Integer sno, String adress) {
        try {


            CustomerModel cus = customerRepository.findById(sno).orElse(null);
            cus.setAddress(adress);
            return new ResponseEntity<CustomerModel>(customerRepository.save(cus), HttpStatus.OK);
        }
    catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
