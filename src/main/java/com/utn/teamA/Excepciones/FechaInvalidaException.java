package com.utn.teamA.Excepciones;

public class FechaInvalidaException extends Exception {

    String msg2;
    /**
     * Constructs an {@code IllegalAccessException} without a
     * detail message.
     */
    public FechaInvalidaException () {
        super();
    }

    /**
     * Constructs an {@code IllegalAccessException} with a detail message.
     *
     * @param   s   the detail message.
     */
    public FechaInvalidaException (String s) {

        super(s);
        msg2=s;
    }

    @Override
    public String getMessage()
    {
        return super.getMessage()+msg2;
    }
}

