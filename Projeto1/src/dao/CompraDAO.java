package dao;

import Modelos.Compra;
import Utils.ConexaoDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

    public void registrarCompra(int usuarioId, int produtoId, int quantidade) {
        String sql = "INSERT INTO compra (usuario_id, produto_id, quantidade) VALUES (?, ?, ?)";
        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            stmt.setInt(2, produtoId);
            stmt.setInt(3, quantidade);
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.err.println("Erro ao registrar compra: " + e.getMessage());
        }
    }

    public List<Compra> listarPorUsuario(int usuarioId) {
        List<Compra> compras = new ArrayList<>();
        String sql = "SELECT c.id, c.quantidade, c.data_compra, p.nome, p.preco " +
                     "FROM compra c INNER JOIN produto p ON c.produto_id = p.id " +
                     "WHERE c.usuario_id = ?";

        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                compras.add(new Compra(
                        rs.getInt("id"),
                        usuarioId,
                        rs.getString("nome"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade"),
                        rs.getTimestamp("data_compra")
                ));
            }

        } catch (SQLException e) {
            System.err.println("Erro ao listar compras: " + e.getMessage());
        }
        return compras;
    }
}
