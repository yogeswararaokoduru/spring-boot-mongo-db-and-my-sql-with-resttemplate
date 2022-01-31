package com.org.cog.practice.service;

import com.org.cog.practice.model.CustomerModel;
import com.org.cog.practice.model.PracModel;

import java.util.List;

public interface PracServiceInt {
    public String create(PracModel pracModel);
    public String createAll(List<PracModel> pracModel);
    public List<PracModel> retrive();
    public PracModel retriveId(Integer sno);
    public PracModel update(PracModel pracModel);
    public PracModel updateOne(Integer sno,Integer ph);
    public PracModel getNam(String name);

    public List<CustomerModel> getAllFromCustomer();
}
