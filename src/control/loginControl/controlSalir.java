package control.loginControl;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class controlSalir implements MouseListener {

    public controlSalir() {
        super();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

        Object[] options = {"Si", "No"};
        int n = JOptionPane.showOptionDialog(null,
                "Desea cerrar la aplicacion?",
                "Confirmar salida",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[1]);
        if (n == 0) {
            System.exit(0);
        }

    }
    @Override
    public void mouseExited(MouseEvent e){

    }
}