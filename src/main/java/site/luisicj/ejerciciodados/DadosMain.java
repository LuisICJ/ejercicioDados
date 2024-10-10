package site.luisicj.ejerciciodados;

import java.util.Random;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Clase principal
 */
public class DadosMain extends Application {

    /**
     * Atributos
     */
    private static final String JUGADOR = "Jugador: ";
    private static final String RIVAL = "Rival: ";
    private Text datosJugador;
    private Text datosRival;
    private Text ganador;

    /**
     * main - punto de entrada
     *
     * @param args - argumentos
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * start - crea la GUI
     *
     * @param escenario - el escenario para las escenas
     */
    @Override
    public void start(Stage escenario) {
        escenario.setTitle("Juego de lucha");
        Random alea = new Random();
        Luchador jugador = new Luchador("Goku");
        Luchador rival = new Luchador("Freezer");
        datosJugador = new Text(JUGADOR + jugador.getNombreLuchador() + " " + jugador.getPuntosVida());
        datosRival = new Text(RIVAL + rival.getNombreLuchador() + " " + rival.getPuntosVida());
        Button btLuchar = new Button("Luchar");
        ganador = new Text("");
        VBox caja = new VBox();
        caja.getChildren().add(datosJugador);
        caja.getChildren().add(btLuchar);
        caja.getChildren().add(datosRival);
        btLuchar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                luchar(alea, jugador, rival);
            }
        });
        caja.getChildren().add(ganador);
        Scene escena = new Scene(caja, 400, 200);
        escenario.setScene(escena);
        escenario.show();
    }

    /**
     * luchar - genera una tirada de dados para cada luchador y determina un perdedor.
     *
     * @param alea - un generador aleatorio
     * @param jugador - el objeto del luchador del jugador
     * @param rival - el objeto del luchador del rival
     */
    private void luchar(Random alea, Luchador jugador, Luchador rival) {
        int dadoJugador = alea.nextInt(6) + 1;
        int dadoRival = alea.nextInt(6) + 1;

        if (dadoJugador > dadoRival) {
            rival.recibirDano();
            actualizarTexto(rival, RIVAL);
        } else if (dadoJugador < dadoRival) {
            jugador.recibirDano();
            actualizarTexto(jugador, JUGADOR);
        }

        int largoGanador = ganador.getText().length();

        if (largoGanador > 0) {
            Platform.exit();
        }

        String inicioGanador = "Ha ganado: ";

        if (jugador.getPuntosVida() == 0) {
            ganador.setText(inicioGanador + rival.getNombreLuchador());
        } else if (rival.getPuntosVida() == 0) {
            ganador.setText(inicioGanador + jugador.getNombreLuchador());
        }

    }

    /**
     * actualizarTexto - actualiza el texto con los puntos de vida del luchador perdedor
     *
     * @param unLuchador - el objeto con del luchador perdedor
     * @param tipoLuchador - el dato de si el luchador es el jugador o el rival
     */
    private void actualizarTexto(Luchador unLuchador, String tipoLuchador) {
        String nuevoTexto = tipoLuchador + unLuchador.getNombreLuchador() + " " + unLuchador.getPuntosVida();

        if (tipoLuchador.equals(RIVAL)) {
            datosRival.setText(nuevoTexto);
        } else {
            datosJugador.setText(nuevoTexto);
        }

    }

}