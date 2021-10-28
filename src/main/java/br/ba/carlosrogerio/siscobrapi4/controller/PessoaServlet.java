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

import br.ba.carlosrogerio.siscobrapi4.dao.PessoaDao;
import br.ba.carlosrogerio.siscobrapi4.model.Pessoa;

@WebServlet(name="Pessoa",
            //loadOnStartup = 1,
            urlPatterns = {"/novaPessoa",
                           "/inserePessoa",
                           "/removePessoa",
                           "/editaPessoa",
                           "/atualizaPessoa",
                           "/listaPessoa"})

public class PessoaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PessoaDao pessoaDao;

    public void init() {
        pessoaDao = new PessoaDao();
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
                case "/novaPessoa":
                    showNewForm(request, response);
                    break;
                case "/inserePessoa":
                    insertPeople(request, response);
                    break;
                case "/removePessoa":
                    deletePeople(request, response);
                    break;
                case "/editaPessoa":
                    showEditForm(request, response);
                    break;
                case "/atualizaPessoa":
                    updatePeople(request, response);
                    break;
                default:
                    listPeople(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPeople(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Pessoa > listOfPeople = pessoaDao.getAllPeople();
        request.setAttribute("listPeople", listOfPeople);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-pessoa.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pessoa.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        Pessoa existingPeople = pessoaDao.getPeople(idPessoa);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pessoa.jsp");
        request.setAttribute("people", existingPeople);
        dispatcher.forward(request, response);

    }

    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        String nomePessoa = request.getParameter("nomePessoa");
        String endereco = request.getParameter("endereco");
        String uf = request.getParameter("uf");
        String telefone = request.getParameter("telefone");
        String documento = request.getParameter("documento");
        String email = request.getParameter("email");
          
        Pessoa novaPessoa = new Pessoa(nomePessoa, endereco, uf, telefone, documento, email);
        pessoaDao.savePeople(novaPessoa);
        response.sendRedirect("listaPessoa");
    }

    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        String nomePessoa = request.getParameter("nomePessoa");
        String endereco = request.getParameter("endereco");
        String uf = request.getParameter("uf");
        String telefone = request.getParameter("telefone");
        String documento = request.getParameter("documento");
        String email = request.getParameter("email");

        Pessoa pessoa = new Pessoa(idPessoa, nomePessoa, endereco, uf, telefone, documento, email);
        pessoaDao.updatePeople(pessoa);
        response.sendRedirect("listaPessoa");
    }

    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int idPessoa = Integer.parseInt(request.getParameter("idPessoa"));
        pessoaDao.deletePeople(idPessoa);
        response.sendRedirect("listaPessoa");
    }
}