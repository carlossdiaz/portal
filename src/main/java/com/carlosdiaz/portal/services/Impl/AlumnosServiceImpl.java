package com.carlosdiaz.portal.services.Impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.carlosdiaz.portal.models.Alumno;
import com.carlosdiaz.portal.services.AlumnosService;

@Service
public class AlumnosServiceImpl implements AlumnosService{

    @Autowired 
    RestTemplate restTemplate;

    @Value("${url.matriculacion.rest.service}")
    String urlMatric;


    @Override
    public List<Alumno> findAll() {
        Alumno[] aa = restTemplate.getForObject(urlMatric + "listar", Alumno[].class);
        List<Alumno> alumnos = Arrays.asList(aa);
        return alumnos;
    }

    @Override
    public Alumno find(int codigo) {
        Alumno alumno = restTemplate.getForObject(urlMatric + "listar/{codigo}", Alumno.class, codigo);
        return alumno;
    }

    @Override
    public void save(Alumno alumno) {
        Alumno alumnoResponse = restTemplate.postForObject(urlMatric + "nuevo/", alumno, Alumno.class);
        alumno.setCodigo(alumnoResponse.getCodigo());
    }

    @Override
    public void update(Alumno alumno) {
        restTemplate.put(urlMatric + "modificar/{codigo}", alumno, alumno.getCodigo());
    }

    @Override
    public void delete(int codigo) {
        restTemplate.delete(urlMatric + "borrar/{codigo}", codigo);
    }
    
}
