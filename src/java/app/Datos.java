package app;

import java.util.ArrayList;
/*

*/

public class Datos {

    private static boolean sw=false;
    public static boolean isSW(){

    return sw;
    }
    private static ArrayList<Auto> arrauto=new ArrayList<Auto>();
    
    protected static void cargarDatos(){
    
        arrauto.add(new Auto("11-11","Mercedez","Naranja",100,"naranja.jpg"));
        arrauto.add(new Auto("22-22","Ferrari","Rojo",590,"rojo.jpg"));
        sw=true;
    }
    
    public static boolean agregar(Auto auto){
    
        if((auto!=null)&&(buscar(auto.getPatente())==null)){
        
            arrauto.add(auto);
            return true;
        }
        return false;
    }
    
    public static ArrayList<Auto> listar(){
        
        return arrauto;
    }
    
    public static Auto buscar(String patente){
    
        Auto autoencontrado=null;
        for(Auto auto:arrauto){
        
            if(auto.getPatente().equals(patente)){
            
                autoencontrado=auto;
                return autoencontrado;
            }
        }
        return autoencontrado;
    }
    
    public static boolean eliminar(String patente){
    
            for(Auto a:arrauto){
            
                if(a.getPatente().equals(patente)){
                
                    arrauto.remove(a);
                    return true;
                }
            }
        
        return false;
    }
    
    public static boolean modificar(Auto auto){
        
        int i=0;
            for(Auto a:arrauto){
            
                if(a.getPatente().equals(auto.getPatente())){
                
                    arrauto.set(i, auto);
                    return true;
                }
                i++;
            }
        
        return false;
        
    
    }
    
    
}
