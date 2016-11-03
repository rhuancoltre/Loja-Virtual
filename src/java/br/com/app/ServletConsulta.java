package br.com.app;

import br.com.controller.Produto;
import br.com.controller.ProdutoDao;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Rhuan
 */
public class ServletConsulta extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            Connection conexao = (Connection) request.getAttribute("conexao");
            ProdutoDao produtoDao = new ProdutoDao();

            List<Produto> Listprodutos = produtoDao.Consulta();

            request.setAttribute("produtos", Listprodutos);
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("mensagem_erro", "Não foi possível carregar os dados.");
            Logger.getLogger(ServletProduto.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/admin.jsp").forward(request, response);
    }

}
