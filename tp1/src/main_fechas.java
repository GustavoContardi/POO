import Fecha.fecha;

import java.time.LocalDate;

public class main_fechas {
    public static void main(String[] arg){
        LocalDate fecha1, fecha2;
        fecha Fecha = new fecha();


        Fecha.setFecha();

        fecha1 = LocalDate.parse("12-08-2023");
        fecha2 = LocalDate.parse("23-12-2023");

        System.out.println(Fecha);

        if (Fecha.estaEntre(fecha1, fecha2)){
            System.out.println("Esta entre "+ fecha1 + " y " + fecha2);
        }
        else System.out.println("No esta entre las fechas");

        if(Fecha.es_mayor(fecha1)){
            System.out.println("la fecha " + Fecha.getFecha() + " es mayor a la fecha " + fecha1);
        }
        else System.out.println("la fecha " + Fecha.getFecha() + " es menor a la fecha " + fecha1);

        if(Fecha.es_menor(fecha2)){
            System.out.println("la fecha " + Fecha.getFecha() + " es menor a la fecha " + fecha1);
        }
        else System.out.println("la fecha " + Fecha.getFecha() + " es mayor a la fecha " + fecha1);
    }
}
