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

import br.ba.carlosrogerio.siscobrapi4.dao.PagamentoDao;
import br.ba.carlosrogerio.siscobrapi4.model.Pagamento;

@WebServlet(name="Pagamento",
            //loadOnStartup = 1,
            urlPatterns = {"/novoPagamento",
                           "/inserePagamento",
                           "/removePagamento",
                           "/editaPagamento",
                           "/atualizaPagamento",
                           "/listaPagamento"})

public class PagamentoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PagamentoDao pagamentoDao;

    public void init() {
        pagamentoDao = new PagamentoDao();
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
                case "/novoPagamento":
                    showNewForm(request, response);
                    break;
                case "/inserePagamento":
                    insertPayment(request, response);
                    break;
                case "/removePagamento":
                    deletePayment(request, response);
                    break;
                case "/editaPagamento":
                    showEditForm(request, response);
                    break;
                case "/atualizaPagamento":
                    updatePayment(request, response);
                    break;                    
                default:
                    listPayment(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listPayment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException, ServletException {
        List < Pagamento > listOfPayment = pagamentoDao.getAllPayment();
        request.setAttribute("listPayment", listOfPayment);
        RequestDispatcher dispatcher = request.getRequestDispatcher("lista-pagamento.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, ServletException, IOException {
        int idPagamento = Integer.parseInt(request.getParameter("idPagamento"));
        Pagamento existingPayment = pagamentoDao.getPayment(idPagamento);
        RequestDispatcher dispatcher = request.getRequestDispatcher("pagamento.jsp");
        request.setAttribute("payment", existingPayment);
        dispatcher.forward(request, response);

    }

    private void insertPayment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        //int idPagamento = Integer.parseInt(request.getParameter("idPagamento"));
        int idDividaPagamento = Integer.parseInt(request.getParameter("idDividaPagamento"));
        String dataPagamento = request.getParameter("dataPagamento");
        float valorPago = Float.parseFloat(request.getParameter("valorPago"));

        Pagamento novoPagamento = new Pagamento(idDividaPagamento, dataPagamento, valorPago);
        pagamentoDao.savePayment(novoPagamento);
        response.sendRedirect("listaPagamento");
    }

    private void updatePayment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int idPagamento = Integer.parseInt(request.getParameter("idPagamento"));
        int idDividaPagamento = Integer.parseInt(request.getParameter("idDividaPagamento"));
        String dataPagamento = request.getParameter("dataPagamento");
        float valorPago = Float.parseFloat(request.getParameter("valorPago"));

        Pagamento novoPagamento = new Pagamento(idPagamento, idDividaPagamento, dataPagamento, valorPago);
        pagamentoDao.updatePayment(novoPagamento);
        response.sendRedirect("listaPagamento");
    }

    private void deletePayment(HttpServletRequest request, HttpServletResponse response)
    throws SQLException, IOException {
        int idPagamento = Integer.parseInt(request.getParameter("idPagamento"));
        pagamentoDao.deletePayment(idPagamento);
        response.sendRedirect("listaPagamento");
    }
}