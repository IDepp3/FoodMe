package com.utn.teamA;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JoseAux {

    private List<Ingrediente> listaDeIngredites = new ArrayList<>();

    public void init(){

        Scanner teclado = new Scanner(System.in);
        char otroIngrediente = 's';

        while ( otroIngrediente == 's' ){
            agregarIngrediente();

            System.out.println("Desea agregar otro ingrediente? [ S/N ] ");
            otroIngrediente = teclado.next().charAt(0);

        }

    }

    public void agregarIngrediente(){

        Ingrediente nuevoIngrediente = new Ingrediente();

        nuevoIngrediente.crear();

        listaDeIngredites.add(nuevoIngrediente);
    }
}
