package utils;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileActions{
    public static void createFiles(){
      try {
          File index = new File("tableIndex.csv");
          if (index.createNewFile()) {
              FileWriter indexWriter = new FileWriter("tableIndex.csv");
              indexWriter.write("chofer,dueño,persona\n0,0,0");
              indexWriter.close();
              System.out.println("File created: " + index.getName());
          }else{
              System.out.println("Index file already exists.");
          }

          File chofer = new File("ChoferData.csv");
          if (chofer.createNewFile()) {
              FileWriter choferWriter = new FileWriter("ChoferData.csv");
              choferWriter.write("choferId,nombre,apellidoMaterno,apellidoPaterno,foto,email,calle,colonia,municipio,estado,numeroExterior,numeroInterior,numLicencia,fechaInicio");
              choferWriter.close();
              System.out.println("File created: " + chofer.getName());
          }else{
              System.out.println("ChoferData file already exists.");
          }

          File dueño = new File("DueñoData.csv");
          if (dueño.createNewFile()) {
              FileWriter dueñoWriter = new FileWriter("DueñoData.csv");
              dueñoWriter.write("dueñoId,nombre,apellidoMaterno,apellidoPaterno,foto,email,calle,colonia,municipio,estado,numeroExterior,numeroInterior,numLicencia,fechaInicio,RFC");
              dueñoWriter.close();
              System.out.println("File created: " + dueño.getName());
          }else{
              System.out.println("DueñoData file already exists.");
          }
      }catch (IOException e){
          e.printStackTrace();
      }
    }

}
