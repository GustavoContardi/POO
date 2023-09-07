package Fecha;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class fecha {
    private LocalDate fecha = null;

    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha() {
        nueva_fecha();
    }

    public void nueva_fecha(){
        String fechatxt;
        Scanner scanner = new Scanner(System.in);

            System.out.print("Ingresar fecha: ");
            fechatxt = scanner.nextLine();

            DateTimeFormatter[] formatos = {
                DateTimeFormatter.ofPattern("dd-MM-yyyy"),
                DateTimeFormatter.ofPattern("MM-dd-yyyy")
            };

        for (DateTimeFormatter formato : formatos) {
            try {
                this.fecha = LocalDate.parse(fechatxt, formato);
                break; // Si se analiza con éxito, sal del bucle
            } catch (DateTimeParseException e) {
                // Si el formato no coincide, continúa con el siguiente
            }
        }
    }

    public boolean estaEntre(LocalDate fecha1, LocalDate fecha2){
        LocalDate fecha_actual = getFecha();
        return ((fecha_actual.isAfter(fecha1) && fecha_actual.isBefore(fecha2)) || (fecha_actual.isAfter(fecha2) && fecha_actual.isBefore(fecha1)));
    }

    public boolean es_mayor(LocalDate fecha1){
        LocalDate fecha_actual = getFecha();
        return fecha_actual.isAfter(fecha1);
    }
    public boolean es_menor(LocalDate fecha1){
        LocalDate fecha_actual = getFecha();
        return fecha_actual.isBefore(fecha1);
    }

}
