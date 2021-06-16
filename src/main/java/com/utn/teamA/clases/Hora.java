package com.utn.teamA.clases;

import com.utn.teamA.utils.Helpers;

import java.util.Scanner;

public class Hora {

    private StringBuilder horas;
    private StringBuilder minutos;
    private StringBuilder segundos;
    //private int h;
    private int m;
    private int s;

    public Hora() {

    }

    public StringBuilder getHoras() {
        return this.horas;
    }

    public StringBuilder getMinutos() {
        return this.minutos;
    }

    public StringBuilder getSegundos() {
        return segundos;
    }

    public void setHoras(StringBuilder horas) {

    }

    public void setMinutos(StringBuilder minutos) {
        this.minutos = minutos;
    }

    public void setSegundos(StringBuilder segundos) {
        this.segundos = segundos;
    }

    public void inserteHoras() {
        boolean check = false;
        do {
            System.out.println("Inserte Hora,formato 24hs");
            int h = Helpers.validarInt();
            if (h >= 0 && h < 10) {
                horas = new StringBuilder("0");
                horas.append(h);
            }else {
                horas = new StringBuilder(String.valueOf(h));
            }

            if (h >= 00 && h < 24 && horas.length() == 2) {
                //setHours(hours);
                check = true;
            } else {
                System.out.println("Invalido, reintente.");
            }
        } while (check == false);
    }

    public void inserteMinutoss() {
        boolean check = false;
        do {

            check = false;
            System.out.println("Inserte minutos,formato 60m");

            m = Helpers.validarInt() ;

            minutos = new StringBuilder(String.valueOf(m));
            if (m >= 0 && m < 10) {
                minutos = new StringBuilder("0");
                minutos.append(m);
            }
            if (m < 60 && m >= 00 && minutos.length() == 2) {
                //setMinutes(minutes);
                check = true;
            } else {
                System.out.println("Invalido, reintente");
            }

        } while (check == false);
    }

    public void insertSeconds() {
        boolean check = false;
        @SuppressWarnings("resource")
        Scanner scan = new Scanner(System.in);
        do {

            check = false;
            System.out.println("Inserte, segundos, formato 24hs");
            s = scan.nextInt();
            segundos = new StringBuilder(String.valueOf(s));
            if (s >= 0 && s < 10) {
                segundos.append("0");
            }
            if (s < 60 && s >= 00 && segundos.length() == 2) {
                check = true;
            } else {
                System.out.println("Invalido, reintente");
            }
        } while (check == false);
    }

    @Override
    public String toString() {
        //System.out.println("The time you inserted is: "+hours +":"+minutes +":"+seconds );
        return "Clock" + "\n" +
                horas + ":" + minutos;
    }

    public void init() {
        inserteHoras();
        inserteMinutoss();
    }

    public void showHora() {
        System.out.println(toString());
    }

    public StringBuilder calcularLlegada(int hsAntes){

        int horaInt = Integer.parseInt(getHoras().toString());
        int horaLlgadaEvento =(horaInt - hsAntes);
        String horaLlegada = String.valueOf(horaLlgadaEvento);
        StringBuilder horaFinaliza = new StringBuilder("");
        return horaFinaliza.append(horaLlegada).append(":").append(getMinutos());

    }

    public StringBuilder setearHoraInicio(){
        StringBuilder horario= new StringBuilder();
        return horario.append(getHoras()).append(":").append(getMinutos());
    }


    public StringBuilder calcularFinalizacion(int hsServicio){

        int horaInt = Integer.parseInt(getHoras().toString());
        int horaFinalizaEvento = (horaInt + hsServicio);
        String horaFinalizaE = String.valueOf(horaFinalizaEvento);
        StringBuilder horaFinaliza = new StringBuilder("");
        return horaFinaliza.append(horaFinalizaE).append(":").append(getMinutos());

    }


}