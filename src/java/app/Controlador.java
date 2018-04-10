package app;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
public class Controlador extends HttpServlet {
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(!Datos.isSW())Datos.cargarDatos();
        String option=request.getParameter("option");
        String patente=request.getParameter("txtpatente");
        String marca=request.getParameter("txtmarca");
        String color=request.getParameter("txtcolor");
        String precio=request.getParameter("txtprecio");
        String foto=request.getParameter("txtfoto");
        String txtcolorf=request.getParameter("txtcolorf");
        
        
        switch(option){
        
            case "LISTAR":
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Resultados</title>");            
                out.println("</head>");
                out.println("<body>");
                for(Auto x:Datos.listar()){
                out.println(x+ "<br>"+ "<br>"+ "<br>");}
                out.println("</body>");
                out.println("</html>");
                out.println("<br><br>");
                out.println("<a href=index.jsp> Volver</a>");
                }break;
                
            case "BUSCAR":
                Auto a=Datos.buscar(patente);
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Autos</h1>");
                out.println("<form method=post action=Controlador>");
                out.println("Patente: <input type=text name=txtpatente value="+a.getPatente()+"><br><br>");
                out.println("Marca: <input type=text name=txtmarca value="+a.getMarca()+"><br><br>");
                out.println("Color: <input type=text name=txt value="+a.getColor()+"><br><br>");
                out.println("Precio: <input type=text name=txtprecio value="+a.getPrecio()+"><br><br>");
                out.println("Foto: "+a.getFoto()+"<br><br>");
                out.println("<input type=submit name=option value=BUSCAR>");
                out.println("<input type=submit name=option value=AGREGAR>");
                out.println("<input type=submit name=option value=ELIMINAR>");
                out.println("<input type=submit name=option value=MODIFICAR>");
                out.println("<input type=submit name=option value=LISTAR>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");
                }break;
            case "AGREGAR":
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                if(Datos.agregar(new Auto(patente,marca,color,Integer.parseInt(precio),foto))){
                out.println("<h1> Auto Ingresado </h1>");}
                else{
                out.println("<h1> Error, no se puedo agregar auto </h1>");}
                out.println("</body>");
                out.println("</html>");
                }
                break;
            case "ELIMINAR":
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                if(Datos.eliminar(patente)){
                out.println("<h1> Auto eliminado</h1>");}
                else{out.println("<h1>Auto NO se pudo eliminar</h1>");}
                out.println("</body>");
                out.println("</html>");
                }
                ;break;
            case "MODIFICAR":
                if(precio.isEmpty()){precio="0";}
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                if(Datos.modificar(new Auto(patente,marca,color,Integer.parseInt(precio),foto))){
                out.println("Auto modificado");
                }else{
                
                    out.println("no se pudo modificar");
                }
                out.println("</body>");
                out.println("</html>");
                }break;
                
            case "Cantidad":
                int cont=0;
                for(Auto x:Datos.listar()){
                
                    if(x.getColor().equalsIgnoreCase(txtcolorf)){cont++;}
                }
                if(cont==0){
                try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("No hay datos");
                out.println("</body>");
                out.println("</html>");
                }
                }else{try (PrintWriter out = response.getWriter()) {
            
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title><center>Resultados</center></title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("Hay "+cont+" Auto(s)<br>");
                for(Auto x:Datos.listar()){
                if(x.getColor().equalsIgnoreCase(txtcolorf)){
                
                    out.println(x+"<br>");
                }
                }
                out.println("</body>");
                out.println("</html>");
                }                    
                }break;
                
            case "Max":
                
                PrintWriter out = response.getWriter();
                if(Datos.listar().size()>0){
                Auto max=Datos.listar().get(0);
                for(Auto x:Datos.listar()){
                
                    if(x.getPrecio()>max.getPrecio()){
                    
                        max=x;
                    }
                }
                
                out.println(max);
                }
                else{
                out.println("Not found");}break;
                
                
        
        }

        
    }
/*href*/
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
