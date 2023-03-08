package com.carlosdiaz.portal.services;

import java.util.List;

import com.carlosdiaz.portal.models.Alumno;

public interface AlumnosService {
    public List<Alumno> findAll();
    public Alumno find(int id);
    public void save(Alumno alumno);
    public void update(Alumno alumno);
    public void delete(int id);
}
