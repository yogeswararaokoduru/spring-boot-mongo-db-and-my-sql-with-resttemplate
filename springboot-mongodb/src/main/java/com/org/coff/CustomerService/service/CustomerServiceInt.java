package com.org.coff.CustomerService.service;

import com.org.coff.CustomerService.model.CustomerModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerServiceInt {
    public String create(CustomerModel customerModel);
    public List<CustomerModel> retriveAll();
    public CustomerModel retriveById(Integer sno);
    public ResponseEntity<CustomerModel> retriv(Integer sno);
    public CustomerModel updte(CustomerModel cus);
    public ResponseEntity<CustomerModel> updteRe(CustomerModel cus);
    public CustomerModel updatePa(Integer sno,String adress);
    public ResponseEntity<CustomerModel> updatePar(Integer sno, String adress);
}
