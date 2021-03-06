package com.utn.teamA.ConexionDatos.interfaces;

import com.utn.teamA.excepciones.ClienteNotieneReservas;

import java.util.List;

public interface ObtenerDatos<T> {

    // region Metodos

    T obtenerRegistro(T t) throws ClienteNotieneReservas;
    List<T> obtenerRegistros();
    boolean actualizarRegistro(T t);
    boolean borrarRegistro(T t);
    boolean agregarRegistro(T t);

    // endregion
}
