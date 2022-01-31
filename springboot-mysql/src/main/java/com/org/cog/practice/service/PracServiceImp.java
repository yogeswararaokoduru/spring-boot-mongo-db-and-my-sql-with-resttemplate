package com.org.cog.practice.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.org.cog.practice.exception.PracticeException;
import com.org.cog.practice.model.CustomerModel;
import com.org.cog.practice.model.PracModel;
import com.org.cog.practice.repository.PracRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PracServiceImp implements PracServiceInt {
    @Autowired
    PracRepository pracRepository;

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Override
    public String create(PracModel pracModel) throws PracticeException {
        List<PracModel> p = pracRepository.findAll();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getPh() == pracModel.getPh() || p.get(i).getSno() == pracModel.getSno()) {
                throw new PracticeException("create another");

            }

        }

        pracRepository.save(pracModel);
        return "cre";

    }

    @Override
    public String createAll(List<PracModel> pracModel) {
        pracRepository.saveAll(pracModel);
        return "created";
    }

    @Override
    public List<PracModel> retrive() {
        return pracRepository.findAll();
    }

    @Override
    public PracModel retriveId(Integer sno) {
        return pracRepository.findById(sno).orElse(null);
    }

    @Override
    public PracModel update(PracModel pracModel) {
        PracModel pracModel1 = pracRepository.findById(pracModel.getSno()).orElse(null);
        pracModel1.setName(pracModel.getName());
        pracModel1.setPh(pracModel.getPh());
        pracRepository.save(pracModel1);
        return pracModel1;
    }

    @Override
    public PracModel updateOne(Integer sno, Integer ph) {
        PracModel pracModel = pracRepository.findById(sno).orElse(null);
        pracModel.setPh(ph);
        pracRepository.save(pracModel);
        return pracModel;
    }

    @Override
    public PracModel getNam(String name) {
        return pracRepository.findByName(name);
    }


    @Override
    public List<CustomerModel> getAllFromCustomer() {
        ObjectMapper mapper=new ObjectMapper();
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(headers);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String body = restTemplate().exchange("http://localhost:8080/api/get", HttpMethod.GET, entity, String.class).getBody();
        List<CustomerModel> customerModels = null;
        try {
            customerModels = mapper.readValue(body, new TypeReference<List<CustomerModel>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return customerModels;
    }
}
