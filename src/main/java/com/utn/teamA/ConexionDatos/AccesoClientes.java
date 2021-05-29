package com.utn.teamA.ConexionDatos;

import java.util.List;

import com.utn.teamA.ConexionDatos.interfaces.ObtenerDatos;
import com.utn.teamA.clases.Cliente;

public class AccesoClientes implements ObtenerDatos<Cliente>{

    // region Implementacion Metodos

    @Override
    public Cliente obtenerRegistro(Object llave) {
        return null;
    }

    @Override
    public List<Cliente> obtenerRegistros() {
        return null;
    }

    @Override
    public boolean actualizarRegistro(Cliente t) {
        return false;
    }

    @Override
    public boolean borrarRegistro(Object llave) {
        return false;
    }

    @Override
    public boolean agregarRegistro(Cliente t) {
        return false;
    }
    
    // endregion
}
