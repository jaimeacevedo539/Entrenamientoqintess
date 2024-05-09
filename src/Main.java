import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException, JAXBException {


        String content = getContentFromFile();

        String[] blocks = getBlocks(content);
        Transaccion transaccion = new Transaccion(getOrigenData(blocks[0]),
                getDestinoData(blocks[1]),
                getMap(blocks[2]),
                getBusinessData(blocks[3]));
        System.out.println();
        exportFile(transaccion);


    }

    public static String[] getBlocks(String content) {
        return content.split("\n",4);
    }

    public static DatosOrigen getOrigenData(String block0) {
        String resultado = block0.split(":")[1];
        resultado = resultado.replace("}", "");
        resultado = resultado.replace("{", "");
        DatosOrigen datos = new DatosOrigen();
        datos.setCodigoBanco(resultado.substring(0, 3));
        datos.setNombreBanco(resultado.substring(3, 7));
        datos.setComprobante(resultado.substring(7, 15));
        datos.setnCuenta(resultado.substring(resultado.length() - 10));
        return datos;
    }

    public static DatosDestino getDestinoData(String block1) {
        String resultado = block1.split(":")[1];
        resultado = resultado.replace("}", "");
        resultado = resultado.replace("{", "");

        DatosDestino datos1 = new DatosDestino();
        datos1.setCodigoBanco(resultado.substring(0, 4));
        datos1.setNombreBanco((resultado.substring(4, 12)));
        datos1.setnCuenta(resultado.substring(resultado.length() - 7));
        return datos1;
    }

    public static Map<String,String> getMap(String bloque2){
        Map<String,String> mapa = new HashMap<>();
        String[] split1= bloque2.split(":",2);
       String [] split2= split1[1].split("\\}\\{");
        for(String recorrido:split2){
            recorrido=recorrido.replace("{","");
            recorrido=recorrido.replace("}","");
            String[] split3= recorrido.split(":");
            mapa.put(split3[0],split3[1]);
        }
        return mapa;
    }
//1. hacer un for para recorrer el array del split, 2.eliminar las llaves que tenga, 3. hacer split por :4.Stringagregar al mapa el key value

    public static Map<String,Object> getBusinessData(String block4){
        String [] array = block4.split("\n");
        Map<String,Object> businessData = new HashMap<>();
        businessData.put("20",getTagOneLine(array,":20:"));
        businessData.put("23B",getTagOneLine(array,":23B:"));
        businessData.put("32A",getTagOneLine(array,":32A:"));
        businessData.put("57A",getTagOneLine(array,":57A:"));
        businessData.put("71",getTagOneLine(array,":71A:"));
        businessData.put("50K",getTag50k(array));
        businessData.put("53A",getTag53A(array));
        businessData.put("59",getTag59(array));
        return businessData;
    }



    public  static String getTagOneLine(String[] array,String tag){
       int pos = findTagPosition(array,tag);
       return array[pos].split(":")[2];
    }

    public static int findTagPosition(String[] data, String tag){
        for(int i=0; i< data.length;i++){
           if( data[i].contains(tag)){
               return i;
           }
        }
        return 0;
    }

    public static Tag50k getTag50k(String[] array){
        int pos = findTagPosition(array,":50K:");
        String rut = array[pos].split(":")[2];
        String nombre = array[++pos];
        String direccion = array[++pos];
        String ciudad = array[++pos];
        String pais = array[++pos];

        return new Tag50k(rut,nombre,direccion,ciudad,pais);
    }

    public static Tag53A getTag53A(String[] array){
        int pos = findTagPosition(array,":53A:");
        String nCuenta = array[pos].split(":")[2];
        String bic = array[++pos];
        return new Tag53A(nCuenta,bic);
    }

    public static Tag59 getTag59(String[] array){
        int pos = findTagPosition(array,":59:");
        String nCuenta = array[pos].split(":")[2];
        String refPago = array[++pos];
        String ciudad = array[++pos];
        String pais = array[++pos];

        return new Tag59(nCuenta,refPago,ciudad,pais);
    }

    public static String getContentFromFile() throws IOException {
        FileReader fr =new FileReader("C:/Users/admin/IdeaProjects/EjercicioMapping/src/MT.txt");
        BufferedReader br = new BufferedReader(fr);
        String text;
        StringBuilder sb = new StringBuilder();
        while ((text = br.readLine())!=null){
            sb.append(text);
            sb.append("\n");
        }
        br.close();
        return sb.toString();
    }

    public static void exportFile(Transaccion transaccion) throws JAXBException, FileNotFoundException {
        String path = "C:/Users/admin/IdeaProjects/EjercicioMapping/src/xmlExample.xml";
        JAXBContext context = JAXBContext.newInstance(Transaccion.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
        marshaller.marshal(transaccion,new FileOutputStream(path));
    }
}