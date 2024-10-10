package site.luisicj.ejerciciodados;

/**
 * Clase Luchador
 */
public class Luchador {

    /**
     * Atributos
     */
    private String nombreLuchador;
    private int puntosVida;

    /**
     * Constructor Luchador - crear un objeto Luchador
     * @param nombreLuchador - nombre del luchador
     */
    public Luchador(String nombreLuchador) {
        this.nombreLuchador = nombreLuchador;
        this.puntosVida = 3;
    }

    /**
     * getNombreLuchador - obtener el nombre del luchador
     * @return nombre del luchador
     */
    public String getNombreLuchador() {
        return nombreLuchador;
    }

    /**
     * setNombreLuchador - establecer el nombre del luchador
     * @param nombreLuchador - nombre del luchador
     */
    public void setNombreLuchador(String nombreLuchador) {
        this.nombreLuchador = nombreLuchador;
    }

    /**
     * getPuntosVida - obtener los puntos de vida
     * @return - los puntos de vida que quedan
     */
    public int getPuntosVida() {
        return puntosVida;
    }

    /**
     * setPuntosVida - establecer los puntos de vida
     * @param puntosVida - los puntos de vida
     */
    public void setPuntosVida(int puntosVida) {
        this.puntosVida = puntosVida;
    }

    /**
     * recidirDano - recibir un punto de daño
     */
    public void recibirDano() {
        this.puntosVida -= 1;
    }

}
