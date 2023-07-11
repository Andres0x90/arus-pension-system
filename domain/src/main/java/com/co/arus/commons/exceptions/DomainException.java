package com.co.arus.commons.exceptions;

public class DomainException extends RuntimeException{
    public static final String DOCUMENTO_INVALIDO = "ERROR! El campo 'documento' debe ser alfanumerico y tener maximo 30 caracteres";
    public static final String NOMBRES_INVALID0 = "ERROR! El campo 'nombres' no debe permitir numeros y la longitud maxima es de 50 caracteres";
    public static final String APELLIDOS_INVALIDO = "ERROR! El campo 'apellidos' no debe permitir numeros y la longitud maxima es de 50 caracteres";

    public DomainException(String message) {
        super(message);
    }
}
