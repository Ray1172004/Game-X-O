import javax.swing.*;

public class Jugador {

    private String simbolo;
    private boolean isTurn;

    public Jugador(String simbolo) {
        this.simbolo = simbolo;
        this.isTurn = false;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public boolean isTurn() {
        return isTurn;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public void realizarMovimiento(JButton button) {
        button.setText(simbolo);
    }
}
