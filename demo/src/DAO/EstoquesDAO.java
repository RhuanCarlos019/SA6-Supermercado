package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Estoque;

public class EstoquesDAO {
    private Connection connection;

    public EstoquesDAO(Connection connection) {
        this.connection = connection;
    }

    // Implemente os métodos de CRUD aqui
    // Exemplo: createEstoque, readEstoques, updateEstoque, deleteEstoque
}
