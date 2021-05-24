package com.wyvern.wyvern.service;

import java.util.ArrayList;

import com.wyvern.wyvern.model.DatosModel;
import com.wyvern.wyvern.repositories.DatosRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatosBDService {
    @Autowired
    DatosRepository datosRepository;

    public ArrayList<DatosModel> obtenerDatos(){
        return (ArrayList<DatosModel>) datosRepository.findAll();

    }

    public DatosModel guardarDatosModel(DatosModel datos) {

        return datosRepository.save(datos);
    }

}
