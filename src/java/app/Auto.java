package app;
public class Auto {
    
    private String patente;
    private String  marca;
    private String  color;
    private int precio;
    private String  foto;
    
    public Auto(){
    
    }

    public Auto(String patente, String marca, String color, int precio,String foto) {
        this.patente = patente;
        this.marca = marca;
        this.color = color;
        this.precio = precio;
        this.foto=  "<img src=imagenes/"+foto+">";
    }
    
    public String getFoto(){
        return  foto;
    }
    
    public void setFoto(String foto){
        this.foto=foto;
    }
    
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "patente: " + patente + ", marca: " + marca + ", color: " + color + ", precio: " + precio+", foto--->"+foto;
    }
    
    
}
