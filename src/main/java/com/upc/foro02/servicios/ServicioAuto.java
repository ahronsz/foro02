package com.upc.foro02.servicios;

import com.upc.foro02.entidades.Auto;

import java.util.List;

public interface ServicioAuto {
    List<Auto> obtenerAutos();
    Auto obtenerEntidad(Long id);
    Auto crearAuto(Auto auto);
    Auto actualizarAuto(Auto auto);
    Auto eliminarAuto(Long id);
}
