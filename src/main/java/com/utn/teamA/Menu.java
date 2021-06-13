package com.utn.teamA;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

    // region atributos

    private String id;
    private TipoMenu tipo;
    private String nombre;
    private String descripcion;
    private List<Plato> listaDePlatos;
    private double precio;
    private boolean estado;


    //endregion

    //region contructores
    public Menu() {

        this.id = UUID.randomUUID().toString();
        this.estado = true;
    }

    public Menu(TipoMenu tipo, String nombre, String descripcion, List<Plato> platos, double precio) {
        this();
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.listaDePlatos = platos;
        this.precio = precio;
    }
    //endregion

    //region getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TipoMenu getTipo() {
        return tipo;
    }

    public void setTipo(TipoMenu tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Plato> getPlatos() {
        return listaDePlatos;
    }

    public void setPlatos(List<Plato> platos) {
        this.listaDePlatos = platos;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setEstado(boolean estado){
        this.estado = estado;
    }

    public boolean getEstado(){
        return this.estado;
    }


    //endregion

    @Override
    public String toString() {
        return Color.ANSI_BLUE + "\n\t MENU \n" +
                Color.ANSI_CYAN + "Tipo: " + Color.ANSI_GREEN + tipo + "\n" +
                Color.ANSI_CYAN + "Nombre:" + Color.ANSI_GREEN + nombre + "\n" +
                Color.ANSI_CYAN + "Precio: " + Color.ANSI_GREEN + precio + '\n' +
                Color.ANSI_CYAN + "Descripcion: " + Color.ANSI_GREEN + descripcion + "\n\n" +
                //TODO buscar y agregar platos al plato
                //Color.ANSI_CYAN + "<<<<< Platos >>>>> " + Color.ANSI_GREEN + "\n" +
                //listaDePlatos + "\n" +
                Color.ANSI_RESET + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;

        if(obj instanceof Menu){
            Menu m = (Menu)obj;
            if(this.getId().equals(m.getId()))
                return true;
        }

        return false;
    }

    public void crear(){

        System.out.println(
                Color.ANSI_BLUE +
                        "\n\n" +
                        " ----------------------------------------\n" +
                        "| \t\t N U E V O    M E N U \t\t |\n" +
                        " ----------------------------------------" +
                        " \n\n" +
                        Color.ANSI_RESET);

        int opcion = 0;
        boolean continuar = false;

        do{

            System.out.println(Color.ANSI_CYAN + "Ingrese tipo:" + Color.ANSI_RESET);
            System.out.println(Color.ANSI_GREEN + " 1 " + Color.ANSI_RESET + " Vegano");
            System.out.println(Color.ANSI_GREEN + " 2 " + Color.ANSI_RESET + " Vegetariano");
            System.out.println(Color.ANSI_GREEN + " 3 " + Color.ANSI_RESET + " Diabetico");
            System.out.println(Color.ANSI_GREEN + " 4 " + Color.ANSI_RESET + " Clasico");

            opcion = Helpers.validarInt();
            continuar = false;


            switch (opcion){
                case 1:
                    this.tipo = TipoMenu.VEGANO;
                    break;
                case 2:
                    this.tipo = TipoMenu.VEGETARIANO;
                    break;
                case 3:
                    this.tipo = TipoMenu.DIABETICO;
                    break;
                case 4:
                    this.tipo = TipoMenu.CLASICO;
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

        System.out.println(Color.ANSI_CYAN + "Ingrese Precio:" + Color.ANSI_RESET);
        this.precio =  Helpers.validarDouble();


        System.out.println( this );

    }


}
