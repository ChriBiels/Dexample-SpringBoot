package com.wyvern.wyvern.repositories;

import com.wyvern.wyvern.model.DatosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatosRepository extends CrudRepository<DatosModel, Long>{

}