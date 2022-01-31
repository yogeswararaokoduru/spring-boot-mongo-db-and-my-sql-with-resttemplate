package com.org.coff.CustomerService.controller;

import com.org.coff.CustomerService.model.CustomerModel;
import com.org.coff.CustomerService.service.CustomerServiceImp;
import com.org.coff.CustomerService.service.CustomerServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    CustomerServiceInt customerServiceInt;
    @PostMapping("/create")
    public String create(@RequestBody CustomerModel customerModel){
        return customerServiceInt.create(customerModel);
    }
    @GetMapping("/get")
    public List<CustomerModel> getCus(){
        return customerServiceInt.retriveAll();
    }
    @GetMapping("/getBy/{sno}")
    public CustomerModel getOne(@PathVariable Integer sno){
        return customerServiceInt.retriveById(sno);
    }
    @GetMapping("/getByI/{sno}")
    public ResponseEntity<CustomerModel> getOn(@PathVariable Integer sno) {
        return customerServiceInt.retriv(sno);
    }
        @PutMapping("/upd")
    public CustomerModel updateCus(@RequestBody CustomerModel customerModel){
        return customerServiceInt.updte(customerModel);
    }
    @PutMapping("/upda")
    public ResponseEntity<CustomerModel> updateCust(@RequestBody CustomerModel customerModel){
        return customerServiceInt.updteRe(customerModel);
    }
    @PatchMapping("/par/{sno}/{address}")
    public CustomerModel updatePar(@PathVariable Integer sno,@PathVariable String address){
        return customerServiceInt.updatePa(sno, address);
    }
    @PatchMapping("/part/{sno}/{address}")
    public ResponseEntity<CustomerModel> updatePart(@PathVariable Integer sno, @PathVariable String address){
        return customerServiceInt.updatePar(sno, address);
    }
}
