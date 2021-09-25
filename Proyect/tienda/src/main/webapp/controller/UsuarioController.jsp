<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="to.TOUsuarios"%>
<%@page import="controller.ControllerUsuarios"%>

<% ControllerUsuarios controladorUsuarios = new ControllerUsuarios();
    String opcion = request.getParameter("opcion");
    if ("listar".equals(opcion)){
        ArrayList<TOUsuarios> usuarios = controladorUsuarios.listarUsuarios();
        out.print(new Gson().toJson(usuarios));
    } else if ("insertar".equals(opcion)){
        
    } else if ("actializar".equals(opcion)){
        
    } else if ("eliminar".equals(opcion)){
        
    } else{
        out.print("Esta opcion no esta disponible");
    }
%>




