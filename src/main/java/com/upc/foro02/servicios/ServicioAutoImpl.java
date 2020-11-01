package com.upc.foro02.servicios;

import com.upc.foro02.entidades.Auto;
import com.upc.foro02.repositorio.RepositorioAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServicioAutoImpl implements ServicioAuto {

    @Autowired
    private RepositorioAuto repositorioAuto;

    @Override
    public List<Auto> obtenerAutos() {
        return (List<Auto>) repositorioAuto.findAll();
    }

    @Override
    public Auto obtenerEntidad(Long id) {
        return repositorioAuto.findById(id).get();
    }

    @Override
    public Auto crearAuto(Auto auto) {
        return repositorioAuto.save(auto);
    }

    @Override
    public Auto actualizarAuto(Auto auto) {
//        Auto a = repositorioAuto.findById(auto.getId()).orElseThrow( () -> new Exception("Nose encuentra"));
        Auto a = obtenerEntidad(auto.getId());
        if (a != null) return repositorioAuto.save(auto);
        else return null;
    }

    @Override
    public Auto eliminarAuto(Long id) {
        Auto a = obtenerEntidad(id);
        if (a != null) {
            repositorioAuto.delete(a);
            return a;
        }
        else return null;
    }
}
