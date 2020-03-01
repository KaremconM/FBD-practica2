package entidades;
import java.util.Calendar;

public class Dueño extends Asociado{
    private int dueñoCount = 0;
    private int dueñoId;
    private String RFC;

    public String toString(){
        String[] properties = {"dueñoId", "nombre", "apellidoMaterno", "apellidoPaterno", "foto", "email", "calle",
        "colonia", "municipio", "estado", "numeroExterior", "numeroInterior", "numLicencia", "fechaInicio", "RFC"};
        String prettyPrinted = "";
        for(String p : properties){
            prettyPrinted += this.get(p)+", ";
        }
        prettyPrinted = prettyPrinted.substring(0, prettyPrinted.length()-2);
        return prettyPrinted;
    }

    public String get(String property){
        switch (property){
            case "dueñoId":
                return this.dueñoId+"";
            case "nombre":
                return this.nombre;
            case "apellidoMaterno":
                return this.apellidoMaterno;
            case "apellidoPaterno":
                return this.apellidoPaterno;
            case "foto":
                return this.foto;
            case "email":
                return this.email;
            case "calle":
                return this.calle;
            case "colonia":
                return this.colonia;
            case "municipio":
                return this.municipio;
            case "estado":
                return this.estado;
            case "numeroExterior":
                return this.numeroExterior+"";
            case "numeroInterior":
                return this.numeroInterior+"";
            case "numLicencia":
                return this.numLicencia;
            case "fechaInicio":
                return this.fechaInicio.YEAR+"-"+this.fechaInicio.MONTH+"-"+this.fechaInicio.DAY_OF_MONTH;
            case "RFC":
                return this.RFC;
            default:
                throw new IllegalArgumentException(property+" is not defined in Dueño");
        }
    }

    public Dueño set(String property, String value){
        switch (property){
            case "nombre":
                this.nombre = value;
                break;
            case "apellidoMaterno":
                this.apellidoMaterno = value;
                break;
            case "apellidoPaterno":
                this.apellidoPaterno = value;
                break;
            case "foto":
                this.foto = value;
                break;
            case "email":
                this.email = value;
                break;
            case "calle":
                this.calle = value;
                break;
            case "colonia":
                this.colonia = value;
                break;
            case "municipio":
                this.municipio = value;
                break;
            case "estado":
                this.estado = value;
                break;
            case "numeroExterior":
                this.numeroExterior = Integer.parseInt(value);
            case "numeroInterior":
                this.numeroInterior = Integer.parseInt(value);
            case "numLicencia":
                this.numLicencia = value;
            case "fechaInicio":
                String[] dateData = value.split("-");
                Calendar newDate = Calendar.getInstance();
                newDate.clear();
                newDate.set(Integer.parseInt(dateData[0]), Integer.parseInt(dateData[1]), Integer.parseInt(dateData[2]));
                this.fechaInicio = newDate;
            case "RFC":
                this.RFC = value;
            default:
                throw new IllegalArgumentException(property+" is not defined in Dueño");
        }
        return this;
    }
}
