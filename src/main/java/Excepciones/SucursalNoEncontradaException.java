package Excepciones;

public class SucursalNoEncontradaException extends RuntimeException {
    public SucursalNoEncontradaException(String mensaje) {
        super(mensaje);
    }
}
