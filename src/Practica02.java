import entidades.*;
import utils.*;

public class Practica02 {
    public static void main(String[] args) {
        System.out.println("Inciando base de datos...");
        if(!FileActions.createFiles() || !FileActions.setTableIndex()){
            System.out.println("Error al inciar base de datos");
            return;
        }
        boolean doActions = true;
        while(doActions){
            printMenu();
            int action = getAction();
            switch (action){
                case 1:
                case 2:
                case 3:
                    System.out.println(action);
                    break;
                case 4:
                    handleCreate();
                    System.out.println("Entrada creada");
                    break;
                case 5:
                    handleDrop();
                    System.out.println("Tabla eliminada");
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    doActions = false;
                    break;
                default:
                    System.out.println("Ingresa solo el numero de la acción deseada (1-4)");
            }
        }
    }

    public static void printMenu(){
        System.out.println("**********MENU PRINCIPAL**********");
        System.out.println("Escribe solo el numero de la acción que deseas realizar");
        System.out.println("1.- Consultar datos");
        System.out.println("2.- Modificar una entrada");
        System.out.println("3.- Borrar una entrada");
        System.out.println("4.- Crear una entrada");
        System.out.println("5.- Borrar una tabla");
        System.out.println("6.- Salir");
    }

    public static int getAction(){
        try{
            int action = Integer.parseInt(System.console().readLine());
            return action;
        }catch(NumberFormatException e){
            return 0;
        }

    }

    public static void handleCreate(){
        System.out.println("Selecciona la tabla en la cual quieres crear una entidad");
        System.out.println("1.- Chofer");
        System.out.println("2.- Dueño");
        System.out.println("3.- Taxi");
        int action = getAction();
        String[] properties;
        boolean validAction = false;
        String tableName = "";
        while(!validAction){
            switch (action){
                case 1:
                    tableName = "Chofer";
                    properties = Chofer.properties;
                    validAction = true;
                    Chofer chofer = new Chofer();
                    System.out.println("Creando una entrada para: "+tableName);
                    for(String p : properties){
                        if(p != "choferId"){
                            System.out.println("Ingresa un valor para: "+p);
                            boolean validValue = false;
                            while(!validValue){
                                try{
                                    String value = System.console().readLine();
                                    chofer.set(p,value);
                                    validValue = true;
                                }catch(Exception e){
                                    System.out.println("Valor invalido para: "+p+" intenta de nuevo");
                                    validValue = false;
                                }
                            }
                        }
                    }
                    FileActions.appendToTable(chofer.toString(), tableName+"Data.csv");
                    break;
                case 2:
                    tableName = "Dueño";
                    properties = Chofer.properties;
                    validAction = true;
                    Dueño dueño = new Dueño();
                    System.out.println("Creando una entrada para: "+tableName);
                    for(String p : properties){
                        if(p != "dueñoId"){
                            System.out.println("Ingresa un valor para: "+p);
                            boolean validValue = false;
                            while(!validValue){
                                try{
                                    String value = System.console().readLine();
                                    dueño.set(p,value);
                                    validValue = true;
                                }catch(Exception e){
                                    System.out.println("Valor invalido para: "+p+" intenta de nuevo");
                                    validValue = false;
                                }
                            }
                        }
                    }
                    FileActions.appendToTable(dueño.toString(), tableName+"Data.csv");
                    break;
                /*case 3:
                    tableName = "Taxi";
                    properties = Taxi.properties;
                    validAction = true;
                    Taxi c = new Taxi();
                    System.out.println("Creando una entrada para: "+tableName);
                    for(String p : properties){
                        if(p != "taxiId"){
                            System.out.println("Ingresa un valor para: "+p);
                            boolean validValue = false;
                            while(!validValue){
                                try{
                                    String value = System.console().readLine();
                                    chofer.set(p,value);
                                    validValue = true;
                                }catch(Exception e){
                                    System.out.println("Valor invalido para: "+p+" intenta de nuevo");
                                    validValue = false;
                                }
                            }
                        }
                    }
                    FileActions.appendToTable(taxi.toString(), tableName+"Data.csv");
                    break;*/
                default:
                    System.out.println("Ingresa solo el numero de la acción deseada (1-3)");
                    action = getAction();
            }
        }
    }

    public static void handleDrop(){
        System.out.println("Selecciona la tabla que quieres eliminar");
        System.out.println("1.- Chofer");
        System.out.println("2.- Dueño");
        System.out.println("3.- Taxi");
        boolean validAction = false;
        int action = getAction();
        while(!validAction){
            switch(action){
                case 1:
                    FileActions.dropTable("Chofer");
                    validAction = true;
                    break;
                case 2:
                    FileActions.dropTable("Dueño");
                    validAction = true;
                    break;
                /*case 3:
                    FileActions.dropTable("Taxi");
                    break;*/
                default:
                    System.out.println("Ingresa solo el numero de la acción deseada (1-3)");
                    action = getAction();
            }
        }
    }
}
