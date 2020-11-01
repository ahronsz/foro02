package com.upc.foro02.facade;

import com.upc.foro02.entidades.Auto;
import com.upc.foro02.servicios.ServicioAuto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AutoFacadeImpl implements AutoFacade{

    @Autowired
    private ServicioAuto servicioAuto;

    @GetMapping("/autos")
    public List<Auto> obtenerAutos() {
        List<Auto> a = null;
        try {
            a = servicioAuto.obtenerAutos();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error, revise su request");
        }
        return a;
    }

    @GetMapping("/auto/{id}")
    public Auto obtenerEntidad(@PathVariable(value= "id") Long id) {
        Auto a = null;
        try {
            a = servicioAuto.obtenerEntidad(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro el auto, revise su request");
        }
        return a;
    }

    @PostMapping("/auto")
    public Auto crearAuto(@RequestBody Auto auto) {
        Auto a = null;
        try {
            a = servicioAuto.crearAuto(auto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No se pudo crear, revise su request");
        }
        return a;
    }

    @PutMapping("/auto")
    public Auto actualizarAuto(@RequestBody Auto auto) {
        Auto a = null;
        try {
            a = servicioAuto.actualizarAuto(auto);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo actualizar, revise su request");
        }
        return a;
    }

    @DeleteMapping("/auto/{id}")
    public Auto eliminarAuto(@PathVariable(value = "id") Long id) {
        Auto a = null;
        try {
            a = servicioAuto.eliminarAuto(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo eliminar, revise su request");
        }
        return a;
    }
}
