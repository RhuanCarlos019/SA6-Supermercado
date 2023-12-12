package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Funcionario;

public class FuncionariosDAO {
    private Connection connection;

    public FuncionariosDAO(Connection connection) {
        this.connection = connection;
    }

    // Implemente os métodos de CRUD aqui
    // Exemplo: createFuncionario, readFuncionarios, updateFuncionario, deleteFuncionario

    public Funcionario getFuncionarioByCPF(Long cpf) throws SQLException {
        String query = "SELECT * FROM funcionarios WHERE cpf_funcionario = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, cpf);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return criarFuncionario(resultSet);
                }
            }
        }
        return null;
    }

    private Funcionario criarFuncionario(ResultSet resultSet) throws SQLException {
        // Extrair os dados do ResultSet e criar um objeto Funcionario
        // Exemplo:
        Long cpf = resultSet.getLong("cpf_funcionario");
        String nome = resultSet.getString("nome_funcionario");
        // ... (outros campos)

        return new Funcionario(cpf, nome /*, ... outros campos */);
    }
}
