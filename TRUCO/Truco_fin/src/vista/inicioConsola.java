package vista;

import controlador.Controlador;
import modelo.Jugador;
import modelo.Partida;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class inicioConsola {
    private JPanel ventana;
    private JPanel botones;
    private JButton btnInicio;
    private JLabel t1;
    private JLabel t2;
    private JLabel t3;
    private JPanel panelTitulo;
    private JLabel titulo;
    private final JFrame frame;

    public inicioConsola() {
        frame = new JFrame("TRUCONTARDI");
        frame.setContentPane(ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 350);

        titulo.setText("¡ BIENVENIDO AL TRUCONTARDI ! ");
        t1.setText("");
        t3.setText("");
        t2.setText("");


        btnInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Jugador j1 = new Jugador("CR7");
                Jugador j2 = new Jugador("Messi");
                Partida partida = new Partida(j1, j2);

                ConsolaGrafica consolaJ1 = new ConsolaGrafica();
                ConsolaGrafica consolaJ2 = new ConsolaGrafica();

                Controlador controladorJ1 = new Controlador(j1, consolaJ1, partida);
                Controlador controladorJ2 = new Controlador(j2, consolaJ2, partida);

                partida.agregarObservador(controladorJ1);
                partida.agregarObservador(controladorJ2);

                consolaJ1.setControlador(controladorJ1);
                consolaJ2.setControlador(controladorJ2);

                consolaJ1.mostrarMenuPrincipal();
                consolaJ2.mostrarMenuPrincipal();
                frame.setVisible(false);
            }
        });
    }


    public void iniciar(){
        frame.setVisible(true);
    }
}
