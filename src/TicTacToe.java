import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe implements ActionListener {

    private JFrame frame = new JFrame();
    private JButton[] buttons = new JButton[9];
    private Jugador jugadorX = new Jugador("X");
    private Jugador jugadorO = new Jugador("O");

    public TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(3, 3));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", Font.PLAIN, 40));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            frame.add(buttons[i]);
        }

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton) e.getSource();

        if (clickedButton.getText().equals("")) {
            if (jugadorX.isTurn()) {
                jugadorX.realizarMovimiento(clickedButton);
            } else {
                jugadorO.realizarMovimiento(clickedButton);
            }

            if (checkForWin()) {
                JOptionPane.showMessageDialog(frame, jugadorX.getSimbolo() + " wins!");
                resetGame();
            } else if (checkForDraw()) {
                JOptionPane.showMessageDialog(frame, "It's a draw!");
                resetGame();
            } else {
                jugadorX.setTurn(!jugadorX.isTurn());
            }
        }
    }

    private boolean checkForWin() {
        return checkLine(0, 1, 2) || checkLine(3, 4, 5) || checkLine(6, 7, 8) ||
                checkLine(0, 3, 6) || checkLine(1, 4, 7) || checkLine(2, 5, 8) ||
                checkLine(0, 4, 8) || checkLine(2, 4, 6);
    }

    private boolean checkLine(int a, int b, int c) {
        return buttons[a].getText().equals(buttons[b].getText()) &&
                buttons[b].getText().equals(buttons[c].getText()) &&
                !buttons[a].getText().equals("");
    }

    private boolean checkForDraw() {
        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    private void resetGame() {
        for (JButton button : buttons) {
            button.setText("");
        }
        jugadorX.setTurn(true);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }
}
