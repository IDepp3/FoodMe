package com.utn.teamA;

import java.util.InputMismatchException;

public class Empresa {

    // region ATRIBUTOS

    private Vista vista;

    // endregion

    // region CONSTRUCTORES

    public Empresa() {
        this.vista = new Vista();
    }

    // endregion

    public void init() {
        menuPrincipal();
    }

    private void menuPrincipal() {
        boolean resp = true;
        String tipoUsuario = "USER";
        while (resp) {
            // menuprincipal app
            this.vista.menuPrincipalVista();
            try {

                switch (this.vista.seleccionarOpcion()) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("VISTA DE LOS MENUS DISPONIBLES");
                        break;
                    case 2:
                        System.out.println("LOGIN");
                        if (tipoUsuario.equals("ADMIN")) {
                            System.out.println("Vista menu ADMIN");
                        } else {
                            menuUSER();
                        }
                        break;
                    case 3:
                        System.out.println("REGISTRO");
                        break;
                    default:
                        System.out.println(this.vista.opcionIncorrecta());
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(this.vista.seleccionarNumeros());
                this.vista.saltoLinea();
            }
        }
    }

    // region MENU CLIENTE

    private void menuUSER() {
        boolean resp = true;

        while (resp) {
            this.vista.menuClientePrincipal();
            try {
                switch (this.vista.seleccionarOpcion()) {
                    case 0:
                        resp = false;
                        break;
                    case 1:
                        System.out.println("VISTA DE LOS MENUS DISPONIBLES");
                        break;
                    case 2:
                        System.out.println("REALIZAR RESERVA");
                        break;
                    case 3:
                        System.out.println("INFORMACION PERSONAL CON LA OPCION DE REALIZAR ALGUN CAMBIO EN SU PERFIL");
                        menuInformacionPersonal();
                        break;
                    default:
                        System.out.println(this.vista.opcionIncorrecta());
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(this.vista.seleccionarNumeros());
                this.vista.saltoLinea();
            }
        }
    }

    private void menuInformacionPersonal(){
        boolean resp = true;

        while(resp){
            this.vista.menuInformacionPersonal();
            try{
                switch (this.vista.seleccionarOpcion()) {
                    case 0:
                        resp = false; 
                        break;
                    case 1:
                        System.out.println("MUESTRA LA INFORMACION PERSONAL ACTUAL");
                        break;
                    case 2:
                        menuModificarDatos();
                        break;
                    case 3:
                        System.out.println("HISTORIAL PERSONAL DE COMPRAS");
                        break;
                    case 4: 
                        System.out.println("LISTA CON COMPRAS PENDIENTES AL DIA DE LA FECHA");
                        System.out.println("Si es existe algun pedido se le puede dar la opcion que modifique algo de la reserva realizada");
                        break;
                    default:
                        System.out.println(this.vista.opcionIncorrecta());
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println(this.vista.seleccionarNumeros());
                this.vista.saltoLinea();
            }
        }
    }

    public void menuModificarDatos(){
        boolean resp = true;
        while(resp){
            this.vista.menuModificarDatos();
            try{
                switch (this.vista.seleccionarOpcion()) {
                    case 0:
                        resp = false; 
                        break;
                    case 1:
                        System.out.println("MODIFICAR PASS");
                        break;
                    case 2:
                        System.out.println("MODIFICAR TELEFONO");
                        break;
                    case 3:
                        System.out.println("MODIFICAR DIRECCION");
                        break;
                    case 4:
                        System.out.println("MODIFICAR EMAIL");
                        break;
                    default:
                        System.out.println(this.vista.opcionIncorrecta());
                        break;
                }
            } catch(InputMismatchException e){
                System.out.println(this.vista.seleccionarNumeros());
                this.vista.saltoLinea();
            }
        }
    }

    // endregion
}
