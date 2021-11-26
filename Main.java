import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    System.out.println("---------------- File ----------------");
        
    File archivo = new File("archivo.txt");
        
    System.out.println("¿Ya existe el archivo?: "+archivo.exists());

    if(!archivo.exists()){
      try{
        boolean seCreo = archivo.createNewFile();
        System.out.println("¿Se creó el archivo?: "+seCreo);

      }catch(IOException e){ //SO no deja crear archivo, no encuentra USB, ya no hay memoria dispobible
        System.out.println("Error: "+ e.getMessage());

      }
    }
    

    System.out.println("---------------- File Writer ----------------");
        
    //dos buffered reader:
    //      -obtener caracteres del teclado
    //      -obtener caracteres o cadenas desde el programa

    try{
      //entrada por teclado almacenada en "texto"
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Escriba texto para el archivo: ");
      String texto = br.readLine();
            
      //apuntador al archivo de texto
      FileWriter fw = new FileWriter("fw.csv"); //crea un nuevo archivo o sobreescibe
            
      //se conecta del programa al archivo
      BufferedWriter bw = new BufferedWriter(fw);
            
      //del lado del archivo, se van a imprimir en él las cadenas. Saca del buffer y lo pasa al archivo
      PrintWriter impresora = new PrintWriter(bw);
            
      impresora.println(texto);

      for(int i=0; i<10; i++)
        impresora.println("Línea "+i+" del for");

      String[] arrayParaTxt = {"a", "e", "i", "o", "u"};
      for(int i=0; i<arrayParaTxt.length; i++)
        impresora.println(arrayParaTxt[i]);

      for(int i=0; i<10; i++)
        impresora.println("Oscar,Baños,Mancilla,318133241,20,33");

      impresora.close();

    }catch(IOException e){ 
      System.out.println("Error: "+ e.getMessage());

    }


    System.out.println("---------------- File Reader ----------------");
        
    try{
      //saca permisos para conectarse con el archivo
      FileReader fr = new FileReader("fw.csv");
            
      //buffer para conectar desde el archivio hacia el programa, saca de archivo y lo mete en br
      BufferedReader br = new BufferedReader(fr);

      String linea = br.readLine();
      while(linea != null){
        System.out.println(linea);
        linea = br.readLine();
      }
      br.close();

    }catch(FileNotFoundException e){
      System.out.println("Error: "+ e.getMessage());
    }catch(IOException e){ 
      System.out.println("Error: "+ e.getMessage());
    }


    System.out.println("---------------- String Tokenizer ----------------");

    String datos = "Jhan,Rodriguez,Arellano,318264794,20,33";

    StringTokenizer tknzador = new StringTokenizer(datos, ",");
        
    int counter = 0;
    String nombre=null, apPat=null, apMat=null;
    int noCuenta=0, edad=0;
    float cred=0;

    while(tknzador.hasMoreTokens()){
      String aux = tknzador.nextToken();
      System.out.println(aux);

      if(counter == 0)
        nombre = aux;
      else if(counter == 1)
        apPat = aux;
      else if(counter == 2)
        apMat = aux;
      else if(counter == 3)
        noCuenta = Integer.parseInt(aux);
      else if(counter == 4)
        edad = Integer.parseInt(aux);
      else if(counter == 5)
        cred = Float.parseFloat(aux);
      counter++;
    }    
    System.out.println("El alumno es:");
    System.out.println(nombre+apPat+apMat+noCuenta+edad+cred);
    counter = 0;
  }
}