package Controller;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import DAO.FuncionariosDAO;
import Model.Funcionario;

public class LoginController {
    private FuncionariosDAO funcionariosDAO = new FuncionariosDAO();

    public Funcionario realizarLogin(Long cpf, String senha) {
        try {
            Funcionario funcionario = funcionariosDAO.getFuncionarioByCPF(cpf);

            if (funcionario != null && funcionario.getSenhaFuncionario().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                return funcionario;
            } else {
                JOptionPane.showMessageDialog(null, "Credenciais inválidas. Tente novamente.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
