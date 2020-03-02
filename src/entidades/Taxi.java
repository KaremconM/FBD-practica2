package entidades;

public class Taxi{
    private static int taxiCount;
    public static String fileName = "TaxiData.csv";
    public static String[] properties = {"taxiId", "año", "numPuertas", "numCilindros", "marca", "modelo", "tieneRefaccion"};
    private int taxiId;
    private int numPuertas;
    private int año;
    private int numCilindros;
    private String modelo;
    private String marca;
    private boolean tieneRefaccion;

    public Taxi(){
        taxiCount++;
        this.taxiId = taxiCount;
    }

    public String toString(){
        String prettyPrinted = "";
        for(String p : properties){
            prettyPrinted += this.get(p)+",";
        }
        prettyPrinted = prettyPrinted.substring(0, prettyPrinted.length()-1);
        return prettyPrinted;
    }

    public String get(String property){
        switch (property){
            case "taxiId":
                return this.taxiId+"";
            case "numPuertas":
                return this.numPuertas+"";
            case "año":
                return this.año+"";
            case "numCilindros":
                return this.numCilindros+"";
            case "modelo":
                return this.modelo;
            case "marca":
                return this.marca;
            case "tieneRefaccion":
                return this.tieneRefaccion+"";
            default:
                throw new IllegalArgumentException(property+" is not defined in Taxi");
        }
    }

    public Taxi set(String property, String value){
        switch (property){
            case "numPuertas":
                this.numPuertas = Integer.parseInt(value);
                break;
            case "año":
                this.año = Integer.parseInt(value);
                break;
            case "numCilindros":
                this.numCilindros = Integer.parseInt(value);
                break;
            case "modelo":
                this.modelo = value;
                break;
            case "marca":
                this.marca = value;
                break;
            case "tieneRefaccion":
                this.tieneRefaccion = (value == "true" || value == "1" || value == "si");
                break;
            default:
                throw new IllegalArgumentException(property+" is not defined in Taxi");
        }
        return this;
    }

    public static void setTableIndex(int index){
        taxiCount = index;
    }

    public static int getCount(){
        return taxiCount;
    }
}
