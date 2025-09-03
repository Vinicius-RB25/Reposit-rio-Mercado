package dao;

import Modelos.Usuario;
import Utils.ConexaoDB;

import java.sql.*;

public class UsuarioDAO {

    public Usuario autenticar(String nome, String cpf) {
        String sql = "SELECT * FROM usuario WHERE nome = ? AND cpf = ?";
        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, cpf);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Usuario(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getBoolean("administrador")
                );
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar usuário: " + e.getMessage());
        }
        return null;
    }

    public boolean inserir(Usuario u) {
        String sql = "INSERT INTO usuario (nome, cpf, administrador) VALUES (?, ?, ?)";
        try (Connection con = ConexaoDB.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getCpf());
            stmt.setBoolean(3, u.isAdministrador());

            int linhas = stmt.executeUpdate();
            if (linhas > 0) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) u.setId(rs.getInt(1));
                return true;
            }

        } catch (SQLException e) {
            System.err.println("Erro ao inserir usuário: " + e.getMessage());
        }
        return false;
    }
}
