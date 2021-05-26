package com.utn.teamA.ConexionDatos.interfaces;

import java.util.List;

public interface ObtenerDatos<T> {
    
    boolean crearRegistro(T t);
    T obtenerRegistro(T t);
    List<T> obtenerRegistros();
    boolean actualizarRegistro(T t);
    boolean borrarRegistro(T t);
    
}
