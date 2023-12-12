package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.model.Usuario;
import main.util.Conexao;

public class LoginDAO {
    private Connection connection;

    public LoginDAO() {
        this.connection = Conexao.getConnection();
    }

    public boolean realizarLogin(String cpf, String senha) {
        String sql = "SELECT * FROM usuarios WHERE cpf_usuario = ? AND senha_usuario = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);
            pstmt.setString(2, senha);

            ResultSet rs = pstmt.executeQuery();

            return rs.next(); // Retorna true se encontrar um registro, indicando sucesso no login

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false; // Retorna false em caso de erro ou se não encontrar registro
    }

    public Usuario obterUsuarioPorCPF(String cpf) {
        String sql = "SELECT * FROM usuarios WHERE cpf_usuario = ?";
        
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, cpf);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Long cpfUsuario = rs.getLong("cpf_usuario");
                String nomeUsuario = rs.getString("nome_usuario");
                Long telefoneUsuario = rs.getLong("telefone_usuario");
                String ruaUsuario = rs.getString("rua_usuario");
                String numeroUsuario = rs.getString("numero_usuario");
                Integer cepUsuario = rs.getInt("cep_usuario");
                String senhaUsuario = rs.getString("senha_usuario");
                String nivelAcessoUsuario = rs.getString("nivel_acesso_usuario");

                return new Usuario(cpfUsuario, nomeUsuario, telefoneUsuario,
                        ruaUsuario, numeroUsuario, cepUsuario, senhaUsuario, nivelAcessoUsuario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
