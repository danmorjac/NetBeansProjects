package Entidad.Exceptions;

public class ProgException extends Exception{
private String messageError;

    public ProgException(String messageError) {
        this.messageError=messageError;
    }

    public String getMessageError() {
        return messageError;
    }
}