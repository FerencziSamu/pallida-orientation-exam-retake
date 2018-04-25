package com.greenfox.cloth.repositories;

import com.greenfox.cloth.models.Cloth;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClothRepository extends CrudRepository<Cloth,Integer>{
  List<Cloth> findAll();
  Cloth findFirstByItemName(String item);

}

