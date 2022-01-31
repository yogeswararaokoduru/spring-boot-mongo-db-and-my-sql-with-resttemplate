package com.org.cog.practice.controller;

import com.org.cog.practice.model.CustomerModel;
import com.org.cog.practice.model.PracModel;
import com.org.cog.practice.service.PracServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PracController {
    @Autowired
    PracServiceInt pracServiceInt;
    @PostMapping("/create")
    public String cre(@RequestBody PracModel pracModel){
        return pracServiceInt.create(pracModel);
    }
    @PostMapping("/createAl")
    public String creAll(@RequestBody List<PracModel> pracModel){
        return pracServiceInt.createAll(pracModel);
    }
    @GetMapping("/get")
    public List<PracModel> ret(){
        return pracServiceInt.retrive();
    }
    @GetMapping("/getCusDet")
    public List<CustomerModel> getDet(){
        return pracServiceInt.getAllFromCustomer();
    }
    @GetMapping("/getOne/{sno}")
    public PracModel retBy(@PathVariable Integer sno){
        return pracServiceInt.retriveId(sno);
    }
    @GetMapping("/getNam/{name}")
    public PracModel retByNam(@PathVariable String name){
        return pracServiceInt.getNam(name);
    }
    @PutMapping("/update")
    public PracModel upd(@RequestBody PracModel pracModel){
        return pracServiceInt.update(pracModel);
    }
    @PatchMapping("/updpar/{sno}/{ph}")
    public PracModel updPar(@PathVariable Integer sno,@PathVariable Integer ph){
        return pracServiceInt.updateOne(sno, ph);
    }



}
