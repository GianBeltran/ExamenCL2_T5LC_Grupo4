package com.pe.cibertec.ExamenCL2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.cibertec.ExamenCL2.modelo.bd.Ubicacion;

@Repository
public interface UbicacionRepository extends JpaRepository<Ubicacion, Integer>{

}
