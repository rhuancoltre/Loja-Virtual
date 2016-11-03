package br.com.app;

import br.com.conexao.Mysql;
import br.com.controller.Produto;
import br.com.controller.ProdutoDao;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServletProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);

        String acao = req.getParameter("acao");
        String id = req.getParameter("id");

        switch (acao) {
            case "listar":
                listaProdutos(req, resp);
                break;

            case "alterar":
                alterarProduto(req, resp, id);
                break;

            case "excluir":
                excluirProduto(req, resp, id);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String id = req.getParameter("id");
        String descricao = req.getParameter("descricao");
        String informacao = req.getParameter("informacao");
        String valor = req.getParameter("valor");
        String qtde = req.getParameter("qtde");

        if (!id.equals("")) {
            prod.setId(Integer.parseInt(id));
        }
        prod.setDescricao(descricao);
        prod.setInformacao(informacao);
        prod.setValor(Double.parseDouble(valor));
        prod.setQtde(Integer.parseInt(qtde));

        if (id.equals("")) {
            cadastrarProduto(prod, req, resp);
        } else {
            try {
                atualizaProduto(prod, req, resp);
            } catch (SQLException e) {
            }
        }
    }
    Produto prod = new Produto();
    ProdutoDao prodDao = new ProdutoDao();

    private void cadastrarProduto(Produto produto, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (!produto.getDescricao().equals("")) {
            try {
                prodDao.inserir(produto);;
                resp.sendRedirect("admin.jsp");
            } catch (SQLException e) {
            }
        }
    }

    private void excluirProduto(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        prod.setId(Integer.parseInt(id));
        try {
            prodDao.remover(prod);
            listaProdutos(req, resp);
        } catch (SQLException e) {
        }
    }

    private void listaProdutos(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Connection conexao = (Connection) req.getAttribute("conexao");
            ProdutoDao produtoDAO = new ProdutoDao();

            List<Produto> produtosList = produtoDAO.Consulta();

            req.setAttribute("produtos", produtosList);
        } catch (SQLException e) {
        }

        req.getRequestDispatcher("/admin.jsp").forward(req, resp);
    }

    private void atualizaProduto(Produto produto, HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        prodDao.atualizar(produto);
        listaProdutos(req, resp);
    }

    private void alterarProduto(HttpServletRequest req, HttpServletResponse resp, String id) throws ServletException, IOException {
        prod.setId(Integer.parseInt(id));
        req.setAttribute("produto", prod);
        req.getRequestDispatcher("/altproduto.jsp").forward(req, resp);

    }
}
