package co.edu.unicesar.sistemas.p2.practica2.vista;

import co.edu.unicesar.sistemas.p2.practica2.datos.ArrayAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.datos.IAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.dominio.AudioLibro;
import co.edu.unicesar.sistemas.p2.practica2.dominio.Libro;
import co.edu.unicesar.sistemas.p2.practica2.dominio.Publicacion;
import co.edu.unicesar.sistemas.p2.practica2.excepciones.ExcepcionAccesoDatos;
import co.edu.unicesar.sistemas.p2.practica2.negocio.RegistroPublicacion;
import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    
    private String titulos[] = {"1. Registrar publicacion",
                              "2. Ver publicaciones",
                              "3. Buscar publicacion",
                              "4. Eliminar publicacion",
                              "0. Salir"};
    
    private int opcion;
    private Scanner lector;
    private RegistroPublicacion logica;

    public VistaConsola() {
        this.lector = new Scanner(System.in);
        this.logica = new RegistroPublicacion();
        
        
    }
    
    public void ejecutarMenu(){
         do{
            
            this.imprimirTitulos();
            this.leerOpcion();
            this.ejecutarOpion();
            
         }while(this.opcion!=0);   
    }
    
    public void imprimirTitulos(){
        
        System.out.println("\nMENU DE LA APLICACION");
        for(int i=0; i< this.titulos.length;i++){
            System.out.println(this.titulos[i]);
        }
    }
    
    public void leerOpcion(){
        
        boolean excepcion=true;
        do{
            try{
                System.out.print("\nSelecciones una opcion: ");
                this.opcion = this.lector.nextInt();
                 excepcion = false;
            }catch(java.util.InputMismatchException ime){
                System.out.println("Se requiere valor entero, intente nuevamente");
                excepcion = true;
                this.lector.nextLine();
            } 
        }while(excepcion);   
    }
    
    public void ejecutarOpion(){
        switch(this.opcion){
            
            case 1: this.vitaInsertarPublicacion();
                    break;
            case 2: this.vitaLeerPublicaciones();
                    break;
            case 3: this.vitaBuscarPublicacion();
                    break;
            case 4: this.vitaEliminarPublicacion();
                    break;
            case 0:  System.out.println("Ha salido de la aplicacion");
                     break;
            default: System.out.println("Opcion no valida, intente nuevamente");
        }
    }
    
    public void vitaInsertarPublicacion(){
        System.out.println(this.titulos[this.opcion-1]);
        // construir el codigo para registrar una publicacion
        
    }
    public void vitaLeerPublicaciones(){
        System.out.println(this.titulos[this.opcion-1]);
         // construir el codigo 
         
    }
    public void vitaBuscarPublicacion(){
       
        System.out.println("");
        System.out.println(this.titulos[this.opcion-1]);
        System.out.print("Isbn a buscar: ");
        String isbn = this.lector.next();
        try{
         Publicacion pub = this.logica.buscarPublicacion(new Libro(isbn));
         if(pub==null){
             System.out.println("La publicacion no esta registrada");
         }
         else{
             System.out.println(pub);
         }
        }catch(ExcepcionAccesoDatos ex){
            System.out.println(ex.getMessage());
        }  
        
    }
    public void vitaEliminarPublicacion(){
        System.out.println(this.titulos[this.opcion-1]);
        // construir el codigo 
    }
    
}
