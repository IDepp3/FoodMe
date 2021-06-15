package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlatoLista {

    private List<Plato> listaDePlatos;
    private PlatoPersistencia platoPersistencia;

    public PlatoLista() {
        this.platoPersistencia = new PlatoPersistencia();
    }

    public void platoMenu(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " ------------------------------------\n" +
                            "| \t\t M E N U    P L A T O \t\t |\n" +
                            " ------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Nuevo Plato");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Plato");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Eliminar Plato");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Listar Platos");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Volver");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    this.agregarPlatoView();
                    break;
                case 2:
                    this.editarPlato();
                    break;
                case 3:
                    this.eliminarPlato();
                    break;
                case 4:
                    this.mostrarPlatosActivos();
                    break;
                default:
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;

            }

        } while( continuar );
    }


    //region agregar plato
    public void agregarPlatoView(){

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){
            agregarPlato();

            System.out.print(
                    Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro plato? " +
                            Color.ANSI_YELLOW + "[" +
                            Color.ANSI_GREEN + " S " +
                            Color.ANSI_YELLOW + "/" +
                            Color.ANSI_RED + " N " +
                            Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();


        }

    }



    public void agregarPlato(){

        Plato nuevoPlato = new Plato();

        System.out.println(
                Color.ANSI_BLUE +
                        "\n\n" +
                        " ----------------------------------------\n" +
                        "| \t\t N U E V O    P L A T O \t\t |\n" +
                        " ----------------------------------------" +
                        " \n\n" +
                        Color.ANSI_RESET);

        int opcion = 0;
        boolean continuar = false;

        do{

            System.out.println(Color.ANSI_CYAN + "Ingrese tipo:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Entrada");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Principal");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Postre");

            opcion = Helpers.validarInt();
            continuar = false;


            switch (opcion){
                case 1:
                    nuevoPlato.setTipo( TipoPlato.ENTRADA );
                    break;
                case 2:
                    nuevoPlato.setTipo( TipoPlato.PRINCIPAL );
                    break;
                case 3:
                    nuevoPlato.setTipo( TipoPlato.POSTRE );
                    break;
                default:
                    continuar = true;
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;
            }
        }while (continuar);

        System.out.println(Color.ANSI_CYAN + "Ingrese nombre:" + Color.ANSI_RESET);
        nuevoPlato.setNombre( Helpers.nextLine() );

        System.out.println(Color.ANSI_CYAN + "Ingrese Descripcion:" + Color.ANSI_RESET);
        nuevoPlato.setDescripcion( Helpers.nextLine() );

        System.out.println(Color.ANSI_CYAN + "Ingrese Precio:" + Color.ANSI_RESET);
        nuevoPlato.setPrecio( Helpers.validarDouble() );

        nuevoPlato.setListaDeIngredites( agregarIngredientes() );

        System.out.println( nuevoPlato );

       platoPersistencia.agregarRegistro(nuevoPlato);
    }

    private List<String> agregarIngredientes(){

        IngredientePersistencia ingredientePersistencia = new IngredientePersistencia();
        List<Ingrediente> listaDeIngredites;
        List<String> ingredientes = new ArrayList<>();

        listaDeIngredites = ingredientePersistencia.obtenerRegistros();

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){

            System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del ingrediente a incorporar" + Color.ANSI_RESET);

            int i = 0;
            for ( Ingrediente ing : listaDeIngredites ) {

                if( ing.getEstado() ){
                    System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + ing.getNombre() );
                }
                i++;
            }

            int codigo = Helpers.validarInt();

            if (codigo < 0 || codigo > listaDeIngredites.size() || !listaDeIngredites.get(codigo).getEstado()){
                System.out.println("opcion invalida");
            }else {
                ingredientes.add( listaDeIngredites.get(codigo).getId() );
            }

            System.out.print(
                    Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro Ingrediente? " +
                            Color.ANSI_YELLOW + "[" +
                            Color.ANSI_GREEN + " S " +
                            Color.ANSI_YELLOW + "/" +
                            Color.ANSI_RED + " N " +
                            Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();

        }

        return ingredientes;
    }


    public void editarPlato(){
        listaDePlatos = platoPersistencia.obtenerRegistros();
        int i = 0;

        System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del plato a editar" + Color.ANSI_RESET);

        for ( Plato plato : listaDePlatos ) {

            if( plato.getEstado() ){
                System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + plato.getNombre() );
            }
            i++;
        }

        System.out.println("");
        int codigo = Helpers.validarInt();

        if (codigo < 0 || codigo > listaDePlatos.size() || !listaDePlatos.get(codigo).getEstado()){
            System.out.println("Opcion invalida");
        }else {
            Plato plato = listaDePlatos.get(codigo);

            plato = editarPlatoVista(plato);

            if( plato.getPlatoId() != null ){
                System.out.println(plato);
                platoPersistencia.actualizarRegistro(plato);
            }

        }

    }

    public Plato editarPlatoVista( Plato plato){
        int opcion = 0;
        boolean continuar = true;

        do{

            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " -------------------------------------------\n" +
                            "| \t\t E D I T A R    P L A T O \t\t |\n" +
                            " -------------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);

            System.out.println(plato);

            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1  Guardar Cambios" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Nombre");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Editar Descripcion");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Editar Tipo");
            System.out.println(Color.ANSI_GREEN + " 5 " + Color.ANSI_RESET + " Editar Precio");
            System.out.println(Color.ANSI_RED + " 0  Cancelar " + Color.ANSI_RESET );

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    plato.setPlatoId(null);
                    break;
                case 1:
                    continuar = false;
                    break;
                case 2:
                    System.out.print(Color.ANSI_CYAN + "Ingrese nombre: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + plato.getNombre() + " >" + Color.ANSI_RESET);
                    plato.setNombre( Helpers.nextLine() );
                    break;
                case 3:
                    System.out.print(Color.ANSI_CYAN + "Ingrese Descripcion: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + plato.getDescripcion() + " >" + Color.ANSI_RESET);
                    plato.setDescripcion( Helpers.nextLine() );
                    break;
                case 4:
                    plato = this.editarTipoDePlato(plato);
                    break;
                case 5:
                    System.out.print(Color.ANSI_CYAN + "Ingrese precio: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + plato.getPrecio() + " >" + Color.ANSI_RESET);
                    plato.setPrecio( Helpers.validarDouble() );
                    break;
                default:
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;
            }

        } while( continuar );

        return plato;
    }

    private Plato editarTipoDePlato(Plato plato){
        int opcion = 0;
        boolean continuar = false;

        do{
            System.out.print(Color.ANSI_CYAN + "Ingrese tipo:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "< " + plato.getTipo() + " >" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Entrada");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Principal");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Postre");

            opcion = Helpers.validarInt();
            continuar = false;

            switch (opcion){
                case 1:
                    plato.setTipo( TipoPlato.ENTRADA );
                    break;
                case 2:
                    plato.setTipo( TipoPlato.PRINCIPAL );
                    break;
                case 3:
                    plato.setTipo( TipoPlato.POSTRE );
                    break;
                default:
                    continuar = true;
                    System.out.println(
                            Color.ANSI_RED +
                                    "\n\t [[ " + opcion + " ]] NO ES UNA OPCION VALIDA \n" +
                                    Color.ANSI_RESET
                    );
                    break;
            }
        }while (continuar);

        return plato;
    }

    public void eliminarPlato(){
        listaDePlatos = platoPersistencia.obtenerRegistros();
        int i = 0;

        System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del plato a eliminar" + Color.ANSI_RESET);

        for ( Plato plato : listaDePlatos ) {

            if( plato.getEstado() ){
                System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + plato.getNombre() );
            }
            i++;
        }

        int codigo = Helpers.validarInt();

        if (codigo < 0 || codigo > listaDePlatos.size() || !listaDePlatos.get(codigo).getEstado()){
            System.out.println("opcion invalida");
        }else {
            Plato plato = listaDePlatos.get(codigo);
            //TODO preguntar si este es el plato a eliminar
            System.out.println(plato);
            platoPersistencia.borrarRegistro(plato);
        }

    }

    public  void mostrarPlatosActivos(){
        listaDePlatos = platoPersistencia.obtenerRegistros();
        for ( Plato plato : listaDePlatos ) {
            if (plato.getEstado()){
                System.out.println(plato);
            }
        }
    }
}
