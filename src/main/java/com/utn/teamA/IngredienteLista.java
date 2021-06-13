package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;

public class IngredienteLista {

    private List<Ingrediente> listaDeIngredites;
    private IngredientePersistencia ingredientePersistencia;

    public IngredienteLista() {
        ingredientePersistencia = new IngredientePersistencia();
    }

    private void agregarIngredienteView(){

        char unElementoMas = 's';

        while ( unElementoMas == 's' ){
            agregarIngrediente();

            System.out.print(
                    Color.ANSI_YELLOW + " \n\n \t\t Desea agregar otro ingrediente? " +
                            Color.ANSI_YELLOW + "[" +
                            Color.ANSI_GREEN + " S " +
                            Color.ANSI_YELLOW + "/" +
                            Color.ANSI_RED + " N " +
                            Color.ANSI_YELLOW + "]" + Color.ANSI_RESET);
            unElementoMas = Helpers.charAt0();


        }

    }

    public void ingredienteMenu(){
        int opcion = 0;
        boolean continuar = true;

        do{
            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " ------------------------------------------------\n" +
                            "| \t\t M E N U    I N G R E D I E N T E \t\t |\n" +
                            " ------------------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);
            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Nuevo Ingrediente");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Ingrediente");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Eliminar Ingrediente");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Listar Ingredientes");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Volver");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    agregarIngredienteView();
                    break;
                case 2:
                    this.editarIngrediete();
                    break;
                case 3:
                    this.eliminarIngrediete();
                    break;
                case 4:
                    this.mostrarIngredientesActivos();
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

    public void agregarIngrediente(){

        Ingrediente nuevoIngrediente = new Ingrediente();

        nuevoIngrediente.crear();

        ingredientePersistencia.agregarRegistro(nuevoIngrediente);

    }

    public void editarIngrediete(){
        listaDeIngredites = ingredientePersistencia.obtenerRegistros();
        int i = 0;

        System.out.println(Color.ANSI_YELLOW + "\t Ingrese el codigo del ingrediente a editar" + Color.ANSI_RESET);

        for ( Ingrediente ing : listaDeIngredites ) {

            if( ing.getEstado() ){
                System.out.println( Color.ANSI_YELLOW + "[ " + i  + " ] " + Color.ANSI_RESET + ing.getNombre() );
            }
            i++;
        }

        System.out.println("");
        int codigo = Helpers.validarInt();

        if (codigo < 0 || codigo > listaDeIngredites.size() || !listaDeIngredites.get(codigo).getEstado()){
            System.out.println("Opcion invalida");
        }else {
            Ingrediente ing = listaDeIngredites.get(codigo);

            ing = editarIngredienteVista(ing);

            if( ing.getId() != null ){
                System.out.println(ing);
                ingredientePersistencia.actualizarRegistro(ing);
            }

        }

    }

    public Ingrediente editarIngredienteVista( Ingrediente ing){
        int opcion = 0;
        boolean continuar = true;

        do{

            System.out.println(
                    Color.ANSI_BLUE +
                            "\n\n" +
                            " ------------------------------------------------\n" +
                            "| \t\t E D I T A R    I N G R E D I E N T E \t\t |\n" +
                            " ------------------------------------------------" +
                            " \n\n" +
                            Color.ANSI_RESET);

            System.out.println(ing);

            System.out.println(Color.ANSI_YELLOW + "\t Ingrese una opcion:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1  Guardar Cambios" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Editar Nombre");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Editar Descripcion");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Editar Precio");
            System.out.println(Color.ANSI_RED + " 0 " + Color.ANSI_RESET + " Cancelar");

            opcion = Helpers.validarInt();

            switch (opcion){
                case 0:
                    continuar = false;
                    ing.setId(null);
                    break;
                case 1:
                    continuar = false;
                    break;
                case 2:
                    System.out.print(Color.ANSI_CYAN + "Ingrese nombre: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + ing.getNombre() + " >" + Color.ANSI_RESET);
                    ing.setNombre( Helpers.nextLine() );
                    break;
                case 3:
                    System.out.print(Color.ANSI_CYAN + "Ingrese Descripcion: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + ing.getDescripcion() + " >" + Color.ANSI_RESET);
                    ing.setDescripcion( Helpers.nextLine() );
                    break;
                case 4:
                    System.out.print(Color.ANSI_CYAN + "Ingrese precio: " + Color.ANSI_RESET);
                    System.out.println(Color.ANSI_YELLOW + "< " + ing.getPrecio() + " >" + Color.ANSI_RESET);
                    ing.setPrecio( Helpers.validarDouble() );
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

        return ing;
    }



    public void eliminarIngrediete(){
        listaDeIngredites = ingredientePersistencia.obtenerRegistros();
        int i = 0;
        for ( Ingrediente ing : listaDeIngredites ) {

            if( ing.getEstado() ){
                System.out.println( "[ " + i  + " ] " + ing.getNombre() );
            }
            i++;
        }

        System.out.println("ingrese el godigo del ingrediente a eliminar");
        int codigo = Helpers.validarInt();

        if (codigo < 0 || codigo > listaDeIngredites.size() || !listaDeIngredites.get(codigo).getEstado()){
            System.out.println("opcion invalida");
        }else {
            Ingrediente ing = listaDeIngredites.get(codigo);
            //TODO preguntar si este es el ingrediente a eliminar
            System.out.println(ing);
            ingredientePersistencia.borrarRegistro(ing);
        }

    }

    public  void mostrarIngredientesActivos(){
        listaDeIngredites = ingredientePersistencia.obtenerRegistros();
        for ( Ingrediente ingrediente : listaDeIngredites ) {
            if (ingrediente.getEstado()){
                System.out.println(ingrediente);
            }
        }
    }
}
