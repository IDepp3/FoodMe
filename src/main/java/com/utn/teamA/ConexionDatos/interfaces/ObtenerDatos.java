package com.utn.teamA.ConexionDatos.interfaces;

import java.util.List;

public interface ObtenerDatos<T> {

    // region Metodos

    T obtenerRegistro(Object llave);
    List<T> obtenerRegistros();
    boolean actualizarRegistro(T t);
    boolean borrarRegistro(Object llave);
    boolean agregarRegistro(T t);

    // endregion
}
