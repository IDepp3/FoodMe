package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoseAux {

    //TODO ver donde va la lista de ingredientes Map o List
    private List<Ingrediente> listaDeIngredites = new ArrayList<>();

    public void init(){

        agregarIngredienteView();

    }

    public void agregarIngrediente(){

        Ingrediente nuevoIngrediente = new Ingrediente();

        nuevoIngrediente.crear();

        listaDeIngredites.add(nuevoIngrediente);
    }

    public void agregarIngredienteView(){

        char otroIngrediente = 's';

        while ( otroIngrediente == 's' ){
            agregarIngrediente();

            System.out.println("Desea agregar otro ingrediente? [ S/N ] ");
            otroIngrediente = Helpers.charAt0();

        }

    }
}
