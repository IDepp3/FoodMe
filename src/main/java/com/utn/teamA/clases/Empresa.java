package com.utn.teamA.modelo;

import java.util.InputMismatchException;

import com.utn.teamA.validaciones.Validaciones;

public class Empresa {

    // region ATTRIBUTES

    private Vista vista;

    public static final String URL_USUARIOS = "src\\main\\recursos\\archivos\\Usuario.json";

    // endregion

    // region CONSTRUCTORS

    public Empresa() {
        this.vista = new Vista();
    }

    // endregion

    // region METHODS

    public void init() {
        menuPrincipal();
    }

    private void menuPrincipal() {
        int opc;
        boolean resp = true;
        while (resp) {
            this.vista.menuPrincipal();
            try {
                opc = this.vista.seleccionOpcion();

                switch (opc) {
                    case 1:
                        System.out.println("Todos los menus");
                        break;
                    case 2:
                        this.vista.login();
                        Usuario user = this.vista.datosUsuario();
                        if(Validaciones.validarNombre(user.getNombre()) && Validaciones.validarPassword(user.getPass())){

                        }
                        break;
                    case 3:
                        resp = false;
                        break;
                    default:
                        System.out.println("La opcion es incorrecta!!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese alguna de las opciones permitidas!!!");
                this.vista.resetScanner();
            }
        }
    }

}
