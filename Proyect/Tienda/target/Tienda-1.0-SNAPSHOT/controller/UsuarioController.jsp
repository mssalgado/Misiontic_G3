<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>
<%@page import="to.TOUsuarios"%>
<%@page import="controller.ControllerUsuarios"%>

<% ControllerUsuarios controladorUsuarios = new ControllerUsuarios();
    String opcion = request.getParameter("opcion");
    if ("listar".equals(opcion)) {
        ArrayList<TOUsuarios> usuarios = controladorUsuarios.listarUsuarios();
        out.print(new Gson().toJson(usuarios));
    } else if ("insertar".equals(opcion)) {
        String datos = request.getParameter("datos");
        TOUsuarios usuarioTO = new Gson().fromJson(datos, TOUsuarios.class);
        controladorUsuarios.insertarUsuario(usuarioTO);

    } else if ("actualizar".equals(opcion)) {
        String datos = request.getParameter("datos");
        TOUsuarios usuarioTO = new Gson().fromJson(datos, TOUsuarios.class);
        controladorUsuarios.actualizarUsuario(usuarioTO);

    } else if ("login".equals(opcion)) {
        String datos = request.getParameter("datos");
        TOUsuarios usuarioTO = new Gson().fromJson(datos, TOUsuarios.class);
        usuarioTO = controladorUsuarios.verificarUsuario(usuarioTO.getNombreUsuario(), usuarioTO.getClave());
        out.print(new Gson().toJson(usuarioTO));

    } else if ("eliminar".equals(opcion)) {
        String datos = request.getParameter("datos");
        TOUsuarios usuarioTO = new Gson().fromJson(datos, TOUsuarios.class);
        controladorUsuarios.eliminarUsuario(usuarioTO);
        
    } else {
        out.print("Esta opcion no esta disponible");
    }
%>