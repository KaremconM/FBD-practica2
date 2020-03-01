import entidades.*;

public class Practica02 {
    public static void main(String[] args) {
        Chofer p = new Chofer();
        //System.out.println(p.toString());
        p.set("nombre", "Cesar Augusto").set("apellidoPaterno", "Farrera").set("apellidoMaterno", "Ortega").set("fechaInicio", "2020-02-29");
        System.out.println(p.toString());
    }
}
