package com.utn.teamA;

import java.sql.Array;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Plato {

    private String platoId;
    private String nombre;
    private List<String> ingredientes;
    private String ingredientesArray[];
    private String descripcion;
    private TipoPlato tipo;
    private boolean estado;
    //TODO el plato no tiene precio ???
    //private double precio;

    //region constructores

    public Plato() {
        this.platoId = UUID.randomUUID().toString();
        this.estado = true;
    }

    public Plato(String nombre, List<String> listaDeIngredites, String descripcion, TipoPlato tipo, boolean estado) {
        this();
        this.nombre = nombre;
        this.ingredientes = listaDeIngredites;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    //endregion

    //region getters and setters

    public String getPlatoId() {
        return platoId;
    }

    public void setPlatoId(String platoId) {
        this.platoId = platoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getListaDeIngredites() {
        return ingredientes;
    }

    public void setListaDeIngredites(List<String> listaDeIngredites) {
        this.ingredientes = listaDeIngredites;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public TipoPlato getTipo() {
        return tipo;
    }

    public void setTipo(TipoPlato tipo) {
        this.tipo = tipo;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String[] getIngredientesArray() {
        return ingredientesArray;
    }

    public void setIngredientesArray(String ingredientesArray[]) {
        this.ingredientesArray = ingredientesArray;
    }

    //endregion


    @Override
    public String toString() {
        return Color.ANSI_BLUE + "\n\t PLATO \n" +
                Color.ANSI_CYAN + "Tipo: " + Color.ANSI_GREEN + tipo + "\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + "\n" +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + "\n\n" +
                //TODO buscar y agregar ingredientes al plato
                Color.ANSI_CYAN + "<<<<< Ingredientes >>>>> " + Color.ANSI_GREEN + "\n" +
                //listaDeIngredites + "\n" +
                this.mostrartIngredientes() + "\n" +
                Color.ANSI_RESET + "\n";
    }

    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Plato){
            Plato p = (Plato)obj;
            if(this.getPlatoId().equals(p.getPlatoId()))
                return true;
        }

        return false;
    }

    public void crear(){

        Scanner teclado = new Scanner(System.in);

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
                    this.tipo = TipoPlato.ENTRADA;
                    break;
                case 2:
                    this.tipo = TipoPlato.PRINCIPAL;
                    break;
                case 3:
                    this.tipo = TipoPlato.POSTRE;
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
        this.nombre =  Helpers.nextLine();

        System.out.println(Color.ANSI_CYAN + "Ingrese Descripcion:" + Color.ANSI_RESET);
        this.descripcion =  Helpers.nextLine();

        System.out.println( this );

    }

    private String mostrartIngredientes(){
        String ingredientes = "";
        IngredientePersistencia ingredientePersistencia = new IngredientePersistencia();
        List<Ingrediente> listaDeIngredites = ingredientePersistencia.obtenerRegistros();
        System.out.println("pasa por aca \n" + this.ingredientesArray);
        if( this.ingredientesArray != null ){
            for ( String ingredienteId : this.ingredientesArray ) {
                if( ingredienteId != null ){
                    for ( Ingrediente ingrediente : listaDeIngredites ) {
                        if(ingrediente.getId().equals( ingredienteId ) ){
                            ingredientes += ingrediente.toString();
                        }
                    }
                }
            }
        }

        return ingredientes;
    }
}
