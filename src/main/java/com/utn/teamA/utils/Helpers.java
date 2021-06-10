package com.utn.teamA.utils;

import java.io.Console;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.utn.teamA.clases.TipoUsuario;

public class Helpers {

    // region ATRIBUTOS

    public static final String VALIDAR_NOMBRE_USUARIO = "^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$";
    public static final String VALIDAR_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$";
    public static final String VALIDAR_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String VALIDAR_NOMBRES = "^([A-Z]{1}[a-z]+[ ]?){1,2}$";
    public static final String VALIDAR_ENTEROS = "^\\d{1,4}$";
    public static final String VALIDAR_TELEFONO = "^\\d{10}$";
    public static final String VALIDAR_DNI = "^[0-9]{7,8}$";

    private static final String LLAVE_ENCRIPTACION = "proyectoFinalProgIII";
    // endregion

    public static String next() {
        return new Scanner(System.in).nextLine().trim();
    }

    public static String nextLine() {
        Scanner teclado = new Scanner(System.in);
        boolean esTextoVacio = false;
        String texto = "";

        do {
            texto = teclado.nextLine();
            if (texto.length() == 0) {
                esTextoVacio = true;
                System.out.print(Color.ANSI_RED + "\n\t EL CAMPO NO PUEDE QUEDAR VACIO \n" + Color.ANSI_CYAN
                        + "\nIngrese un dato:");
            } else {
                esTextoVacio = false;
            }
        } while (esTextoVacio);

        return texto;
    }

    public static char charAt0() {
        Scanner teclado = new Scanner(System.in);
        return teclado.next().charAt(0);
    }

    public static double validarDouble() {
        Scanner teclado = new Scanner(System.in);
        boolean esDouble = false;
        double num = 0;
        do {
            String cadena = teclado.nextLine();
            try {
                num = Double.parseDouble(cadena);
                esDouble = true;
            } catch (NumberFormatException nfe) {
                System.out.println(Color.ANSI_RED + "\n\t [[ " + cadena + " ]] NO ES UN DATO VALIDO \n"
                        + Color.ANSI_CYAN + "\nIngrese un numero:");
            }
        } while (!esDouble);
        return num;
    }

    public static int validarInt() {
        Scanner teclado = new Scanner(System.in);
        boolean esInt = false;
        int num = 0;
        do {
            String cadena = teclado.nextLine();
            try {
                num = Integer.parseInt(cadena);
                esInt = true;
            } catch (NumberFormatException nfe) {
                System.out.println(Color.ANSI_RED + "\n\t [[ " + cadena + " ]] NO ES UN DATO VALIDO \n"
                        + Color.ANSI_CYAN + "\nIngrese un numero:");
            }
            teclado.reset();
        } while (!esInt);
        return num;
    }

    public static String validarTelefono() {
        Scanner teclado = new Scanner(System.in);
        boolean resp = true;
        String cadena;
        do {
            System.out.print(Color.ANSI_GREEN + "Ingrese numero de telefono : " + Color.ANSI_RESET);
            cadena = teclado.nextLine();
            if (cadena.matches("^\\d{10}$"))
                resp = false;
            else
                Vista.opcionIncorrecta("El numero de telefono no es valido", cadena);
        } while (resp);
        return cadena;
    }

    public static boolean validarEmail(String email) {

        Pattern pattern = Pattern.compile(
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(email);

        boolean resp = mather.find();

        if (resp == true) {
            System.out.println("Email ingresado es valido");
        } else {
            System.out.println("El email ingresado no es valido");
        }

        return resp;

    }

    public static boolean validarDni(String dni) {

        Pattern pattern = Pattern.compile("^[0-9]{7,8}$");
        Matcher mather = pattern.matcher(dni);

        boolean resp = mather.find();

        if (resp == true) {
            System.out.println("El dni ingresado es valido");
        } else {
            System.out.println("El dni es incorrecto");
        }
        return resp;
    }

    public static boolean validarTel(String telefono) {

        Pattern pattern = Pattern.compile("^\\d{10}$");
        Matcher mather = pattern.matcher(telefono);

        boolean resp = mather.find();

        if (resp == true) {

        } else {
            System.out.println("El telefono es invalido.");
        }

        return resp;
    }

    public static LocalDate validarFecha() {
        boolean resp = true;
        int dia, mes, anio;
        LocalDate fecha = null;

        while (resp) {
            dia = Integer.parseInt(Helpers.validaciones("Dia", Helpers.VALIDAR_ENTEROS, "Ingrese solo numeros"));
            mes = Integer.parseInt(Helpers.validaciones("Dia", Helpers.VALIDAR_ENTEROS, "Ingrese solo numeros"));
            anio = Integer.parseInt(Helpers.validaciones("Dia", Helpers.VALIDAR_ENTEROS, "Ingrese solo numeros"));
            try{
                fecha = LocalDate.of(anio, mes, dia);
                resp = false;
            } catch(DateTimeException e){
                Vista.opcionIncorrecta("La fecha ingresada es incorrecta intente nuevamente");
            }

        }
        return fecha;
    }

    public static String validaciones(String campo, String validacion, String error) {
        boolean resp = true;
        String ingreso = "";

        while (resp) {
            Vista.ingreseDato(campo);
            ingreso = Helpers.next();
            if (ingreso.matches(validacion))
                resp = false;
            else
                Vista.opcionIncorrecta(error, ingreso);
        }
        return ingreso;
    }

    public static String validarPassword(String mensaje) {
        Console c;
        boolean resp = true;
        String valor = "";
        char[] password = null;
        while (resp) {
            if ((c = System.console()) != null) {
                Vista.ingreseDato(mensaje);
                password = c.readPassword();
            }
            valor = String.valueOf(password);

            if (valor.matches(Helpers.VALIDAR_PASSWORD))
                resp = false;
            else
                Vista.opcionIncorrecta(
                        "Su contraseña debe ser como minimo de 8 caracteres maximo 15, 1 mayuscula, 1 minuscula, 1 digito, no espacios en blanco y al menos 1 caracter especial($@!%*?&)",
                        valor);
        }

        return valor;
    }

    public static String ingresoPassword() {
        String valor = "";
        String password = null;
        Vista.ingreseDato("Ingrese password");
        password = Helpers.nextLine();
        valor = String.valueOf(password);

        return valor;
    }



    private static SecretKeySpec crearClave(String llave) {
        SecretKeySpec secretKeySpec = null;
        MessageDigest messageDigest = null;
        byte[] cadena;

        try {
            cadena = llave.getBytes("UTF-8");
            messageDigest = MessageDigest.getInstance("SHA-1");
            cadena = messageDigest.digest(cadena);
            cadena = Arrays.copyOf(cadena, 16);
            secretKeySpec = new SecretKeySpec(cadena, "AES");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return secretKeySpec;
    }

    public static String encriptarPassword(String pass) {
        String encriptada = "";
        SecretKeySpec secretKeySpec = null;
        Cipher cipher;
        byte[] cadena, resultado;

        try {
            secretKeySpec = crearClave(LLAVE_ENCRIPTACION);
            cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            cadena = pass.getBytes("UTF-8");
            resultado = cipher.doFinal(cadena);
            encriptada = Base64.getEncoder().encodeToString(resultado);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        return encriptada;
    }

    public static String generarID() {
        return UUID.randomUUID().toString().substring(0, 10).replace("-", "T");
    }

    public static boolean estadoActivo() {
        return true;
    }

    public static TipoUsuario tipoCliente() {
        return TipoUsuario.CLIENTE;
    }

    public static TipoUsuario tipoAdministrador() {
        return TipoUsuario.ADMINISTRADOR;
    }

    public static LocalDate fechaActual() {
        return LocalDate.now();
    }
}
