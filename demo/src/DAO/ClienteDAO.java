package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ClientesDAO {
    private Connection connection;

    public ClientesDAO(Connection connection) {
        this.connection = connection;
    }

    // Implemente os métodos de CRUD aqui
    // Exemplo: createCliente, readClientes, updateCliente, deleteCliente
}
