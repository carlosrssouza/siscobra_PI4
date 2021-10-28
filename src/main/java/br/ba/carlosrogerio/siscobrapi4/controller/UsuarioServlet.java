package br.ba.carlosrogerio.siscobrapi4.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ba.carlosrogerio.siscobrapi4.dao.UsuarioDao;
import br.ba.carlosrogerio.siscobrapi4.model.Usuario;

@WebServlet(name="Usuario",
            //loadOnStartup = 1,
            urlPatterns = {"/novoUsuario",
                           "/insereUsuario",
                           "/removeUsuario",
                           "/editaUsuario",
                           "/atualizaUsuario",
                           "/listaUsuario"})

public class UsuarioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;

    public void init() {
        usuarioDao = new UsuarioDao();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/novoUsuario":
                    showNewForm(request, response);
                    break;
                case "/insereUsuario":
                    insertUser(request, response);
                    break;
                case "/removeUsuario":
                    deleteUser(request, response);
                    break;
                case "/editaUsuario":
                    showEditForm(request, response);
                    break;
                case "/atualizaUsuario":
                    updateUser(request, response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Usuario > listOfUser = usuarioDao.getAllUser();
        request.setAttribute("listUser", listOfUser);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-usuario.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        String login = request.getParameter("login");
        Usuario existingUser = usuarioDao.getUser(login);
        RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
        request.setAttribute("user", existingUser);
        dispatcher.forward(request, response);

    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String cargo = request.getParameter("cargo");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");
        
        Usuario novoUsuario = new Usuario(nome, cargo, login, senha, email);
        usuarioDao.saveUser(novoUsuario);
        response.sendRedirect("listaUsuario");
    }

    private void updateUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String nome = request.getParameter("nome");
        String cargo = request.getParameter("cargo");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        String email = request.getParameter("email");

        Usuario usuario = new Usuario(nome, cargo, login, senha, email);
        usuarioDao.updateUser(usuario);
        response.sendRedirect("listaUsuario");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        String login = request.getParameter("login");
        usuarioDao.deleteUser(login);
        response.sendRedirect("listaUsuario");
    }
}