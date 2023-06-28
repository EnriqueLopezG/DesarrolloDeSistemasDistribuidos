package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Test2 {
	 public static void main(String[] args) {
	        // Ruta de la carpeta a leer
	        String rutaCarpeta = "C:/Users/enriq/Downloads/LIBROS_TXT/LIBROS_TXT/";
	        
	        // Crear objeto File con la ruta de la carpeta
	        File carpeta = new File(rutaCarpeta);
	        
	        // Verificar si la ruta es una carpeta
	        if (carpeta.isDirectory()) {
	            // Obtener la lista de archivos en la carpeta
	            File[] archivos = carpeta.listFiles();
	            
	            // Recorrer cada archivo
	            int con = 0;
	            for (File archivo : archivos) {
	                // Verificar si el objeto es un archivo
	                if (archivo.isFile()) {
	                    String nombreArchivo = archivo.getName();
	                    String extensionArchivo = obtenerExtension(nombreArchivo);
	                    int numLineas = contarLineasArchivo(archivo);
	                    System.out.println("B"+(con+1)+"(\"src/main/resources/books/" + nombreArchivo + "\","+numLineas+"),");
	                    
	                    // Contar el número de líneas del archivo
	                   
	                    
	                    //System.out.println("-------------------------------------------");
	                }
	                con++;
	            }
	        } else {
	            System.out.println("La ruta no es una carpeta válida.");
	        }
	    }
	    
	    // Método para obtener la extensión de un archivo
	    private static String obtenerExtension(String nombreArchivo) {
	        String extension = "";
	        
	        int indicePunto = nombreArchivo.lastIndexOf(".");
	        if (indicePunto != -1) {
	            extension = nombreArchivo.substring(indicePunto + 1);
	        }
	        
	        return extension;
	    }
	    
	    // Método para contar el número de líneas de un archivo
	    private static int contarLineasArchivo(File archivo) {
	        int numLineas = 0;
	        
	        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
	            String linea;
	            while ((linea = br.readLine()) != null) {
	                numLineas++;
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        
	        return numLineas;
	    }
}
