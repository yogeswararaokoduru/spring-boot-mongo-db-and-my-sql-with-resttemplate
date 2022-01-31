package com.org.cog.practice.repository;

import com.org.cog.practice.model.PracModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PracRepository extends JpaRepository<PracModel,Integer> {
    PracModel findByName(String name);
}
