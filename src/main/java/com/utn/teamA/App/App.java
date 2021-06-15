package com.utn.teamA.App;

import java.util.ArrayList;
import java.util.List;

import com.utn.teamA.ConexionDatos.AccesoClientes;
import com.utn.teamA.clases.*;


public class App {
    public static void main(String[] args) {
        new Empresa().iniciarSistema();
        /* List<Cliente> clientes = new ArrayList<>();
        AccesoClientes ac = new AccesoClientes();
        ac.guardarInformacion(clientes) */;
    }

}

