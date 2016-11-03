package br.com.controller;

import br.com.conexao.Mysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author Rhuan
 */
public class ProdutoDao extends Mysql {

    Connection con;

    public ProdutoDao() {
        con = Mysql.getConexaoMySQL();
    }

    public void inserir(Produto objeto) throws SQLException {

        PreparedStatement ps = con.prepareStatement(
                "INSERT INTO PRODUTO (DESCRICAO, INFORMACAO, VALOR, QTDE) VALUES (?, ?, ?, ?)");
        ps.setString(1, objeto.getDescricao());
        ps.setString(2, objeto.getInformacao());
        ps.setDouble(3, objeto.getValor());
        ps.setInt(4, objeto.getQtde());
        ps.execute();
        ps.close();
    }

    public void atualizar(Produto objeto) throws SQLException {
        PreparedStatement ps = con.prepareStatement(" UPDATE PRODUTO SET DESCRICAO = ?, INFORMACAO = ?, VALOR = ?"
                + " WHERE ID = ? ");

        ps.setString(1, objeto.getDescricao());
        ps.setString(2, objeto.getInformacao());
        ps.setDouble(3, objeto.getValor());
        ps.setInt(4, objeto.getId());
        ps.execute();
        ps.close();
    }

    public void remover(Produto objeto) throws SQLException {
        PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUTO WHERE ID = ?");
        ps.setInt(1, objeto.getId());
        ps.execute();
        ps.close();

    }

    public List<Produto> Consulta() throws SQLException {
        String sql = "SELECT * FROM PRODUTO";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Produto> produtos = new ArrayList<Produto>();

        while (rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("ID"));
            prod.setDescricao(rs.getString("DESCRICAO"));
            prod.setInformacao(rs.getString("INFORMACAO"));
            prod.setValor(rs.getDouble("VALOR"));
            produtos.add(prod);
        }
        rs.close();
        return produtos;
    }

}
