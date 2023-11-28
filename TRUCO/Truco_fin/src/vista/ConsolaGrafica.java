package vista;

import controlador.Controlador;
import modelo.Carta;
import vista.flujos.Flujo;
import vista.flujos.FlujoMenuPrincipal;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsolaGrafica {
    private final JFrame frame;
    private JButton btnEnter;
    private JTextArea txtVista;
    private JTextField txtEntrada;
    private JPanel ventana;
    private JLabel puntajesTotales;
    private Controlador controlador;
    private Flujo flujoActual;

    public ConsolaGrafica() {
        frame = new JFrame("TRUCONTARDI");
        frame.setContentPane(ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(500, 350);

        btnEnter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // txtVista.append(txtEntrada.getText() + "\n");
                procesarEntrada(txtEntrada.getText());
                txtEntrada.setText("");
            }
        });
        puntajesTotales.setText("PUNTAJES");

    }

    public void limpiarPantalla(){
        mostrar();
        txtVista.setText("");
    }
    public void setControlador(Controlador controlador){
        this.controlador = controlador;
    }
    private void procesarEntrada(String input) {
        input = input.trim();
        if (input.isEmpty()) {
            return;
        }
        flujoActual = flujoActual.procesarEntrada(input);
        flujoActual.mostrarSiguienteTexto();
    }
    public void mostrar() {
        frame.setVisible(true);
    }
    public void println(String texto) {
        txtVista.append(texto + "\n");
    }


    public void mostrarOpciones(){
        println("");
        if(controlador.estadoTrucos() == 1){
            if(controlador.estadoEnvido()) println("2- Truco | 3- Tirar Carta | 4- Ir al mazo");
            else println("1- Envido | 2- Truco | 3- Tirar Carta | 4- Ir al mazo");
        }
        else if(controlador.estadoTrucos() == 2){
            println("2- Re Truco | 3- Tirar Carta | 4- Ir al mazo");
        }
        else if(controlador.estadoTrucos() == 3){
            println("2- Vale Cuatro | 3- Tirar Carta | 4- Ir al mazo");
        }
        else println("3- Tirar Carta | 4- Ir al mazo");

    }

    public void mostrarCartas(){
        ArrayList<Carta> cartas = controlador.obtenerCartas();
        int p = 1;
        for(int i=0; i< cartas.size(); i++){
            println(p + "- " +cartas.get(i).toString());
            p++;
        }
    }
    public void opSalir(){
        frame.setVisible(false );
    }

    public void mostrarMenuPrincipal(){
        mostrar();
        flujoActual = new FlujoMenuPrincipal(this, controlador);
        flujoActual.mostrarSiguienteTexto();
    }

    public void seActualizaronPuntos(String datos){
        puntajesTotales.setText(datos);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void setFlujoActual(Flujo flujoActual) {
        this.flujoActual = flujoActual;
        flujoActual.mostrarSiguienteTexto();
    }
}
