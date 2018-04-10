
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Autos</h1>
        <form method="post" action="Controlador">
        Patente: <input type="text" name="txtpatente" value=""><br><br>
        Marca: <input type="text" name="txtmarca" value=""><br><br>
        Color: <input type="text" name="txtcolor" value=""><br><br>
        Precio: <input type="text" name="txtprecio" value=""><br><br>
        Foto:   <input  type="text" name="txtfoto"  value=""><br><br>
        
        <input type="submit" name="option" value="BUSCAR">
        <input type="submit" name="option" value="AGREGAR">
        <input type="submit" name="option" value="ELIMINAR">
        <input type="submit" name="option" value="MODIFICAR">
        <input type="submit" name="option" value="LISTAR"><br><br>
        <input  type="text" name="txtcolorf"    value="">
        <input  type="submit"   name="option"   value="Cantidad"><br><br>
        <input  type="submit"   name="option"   value="Max"><br><br>
        <input  type="reset"    name="reset"    value="RESET">
        </form>
        
    </body>
</html>
