package Controller;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DAO.FuncionariosDAO;
import Model.Funcionario;

public class FuncionariosController {
    private FuncionariosDAO funcionariosDAO = new FuncionariosDAO();
    private List<Funcionario> funcionarios;
    private DefaultTableModel tableModel;
    private JTable table;

    public FuncionariosController(List<Funcionario> funcionarios, DefaultTableModel tableModel, JTable table) {
        this.funcionarios = funcionarios;
        this.tableModel = tableModel;
        this.table = table;
    }

    public void cadastrarFuncionario(Long cpfFuncionario, String nomeFuncionario, Long telefoneFuncionario,
            String ruaFuncionario, String numeroFuncionario, Integer cepFuncionario, String senhaFuncionario,
            String nivelAcessoFuncionario) {
        if (validarCamposFuncionario(cpfFuncionario, nomeFuncionario, telefoneFuncionario, ruaFuncionario,
                numeroFuncionario, cepFuncionario, senhaFuncionario, nivelAcessoFuncionario)) {
            try {
                funcionariosDAO.create(cpfFuncionario, nomeFuncionario, telefoneFuncionario, ruaFuncionario,
                        numeroFuncionario, cepFuncionario, senhaFuncionario, nivelAcessoFuncionario);

                Funcionario funcionario = new Funcionario(cpfFuncionario, nomeFuncionario, telefoneFuncionario,
                        ruaFuncionario, numeroFuncionario, cepFuncionario, senhaFuncionario, nivelAcessoFuncionario);
                funcionarios.add(funcionario);

                atualizarTabela();
                JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizarFuncionario(int linhaSelecionada, Long cpfFuncionario, String nomeFuncionario,
            Long telefoneFuncionario, String ruaFuncionario, String numeroFuncionario, Integer cepFuncionario,
            String senhaFuncionario, String nivelAcessoFuncionario) {
        if (validarCamposFuncionario(cpfFuncionario, nomeFuncionario, telefoneFuncionario, ruaFuncionario,
                numeroFuncionario, cepFuncionario, senhaFuncionario, nivelAcessoFuncionario) && linhaSelecionada != -1) {
            try {
                funcionariosDAO.update(cpfFuncionario, nomeFuncionario, telefoneFuncionario, ruaFuncionario,
                        numeroFuncionario, cepFuncionario, senhaFuncionario, nivelAcessoFuncionario);

                Funcionario funcionario = new Funcionario(cpfFuncionario, nomeFuncionario, telefoneFuncionario,
                        ruaFuncionario, numeroFuncionario, cepFuncionario, senhaFuncionario, nivelAcessoFuncionario);
                funcionarios.set(linhaSelecionada, funcionario);

                atualizarTabela();
                JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void excluirFuncionario(int linhaSelecionada, Long cpfFuncionario) {
        try {
            if (linhaSelecionada != -1) {
                funcionariosDAO.delete(cpfFuncionario);
                funcionarios.remove(linhaSelecionada);

                atualizarTabela();
                JOptionPane.showMessageDialog(null, "Funcionário excluído com sucesso!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        Object linha[] = new Object[8];
        for (int i = 0; i < funcionarios.size(); i++) {
            linha[0] = funcionarios.get(i).getCpfFuncionario();
            linha[1] = funcionarios.get(i).getNomeFuncionario();
            linha[2] = funcionarios.get(i).getTelefoneFuncionario();
            linha[3] = funcionarios.get(i).getRuaFuncionario();
            linha[4] = funcionarios.get(i).getNumeroFuncionario();
            linha[5] = funcionarios.get(i).getCepFuncionario();
            linha[6] = funcionarios.get(i).getSenhaFuncionario();
            linha[7] = funcionarios.get(i).getNivelAcessoFuncionario();
            tableModel.addRow(linha);
        }
    }

    public boolean validarCamposFuncionario(Long cpf, String nome, Long telefone, String rua, String numero, Integer cep,
            String senha, String nivelAcesso) {
        // Verifica se os campos estão preenchidos
        if (cpf == 0 || nome.isEmpty() || senha.isEmpty() || nivelAcesso.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO!\nCampos obrigatórios estão em branco");
            return false;
        }
        if (!validarFormatoCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "CPF inválido!\nO CPF deve conter apenas números e ter 11 dígitos!");
            return false;
        }
        if (!validarFormatoTelefone(telefone)) {
            JOptionPane.showMessageDialog(null,
                    "Telefone inválido!\nO Telefone deve conter apenas números e ter entre 9 e 11 dígitos!");
            return false;
        }
        if (!validarFormatoNumero(numero)) {
            JOptionPane.showMessageDialog(null,
                    "Número inválido!\nO Número deve conter até 10 dígitos e no máximo 1 letra!");
            return false;
        }
        if (!validarFormatoCEP(cep)) {
            JOptionPane.showMessageDialog(null, "CEP inválido!\nO CEP deve conter apenas números e ter 8 dígitos!");
            return false;
        }
        if (!validarFormatoSenha(senha)) {
            JOptionPane.showMessageDialog(null,
                    "Senha Inválida!\nA senha deve ter menos de 24 dígitos e não pode ser nula!");
            return false;
        }

        return true;
    }

    private boolean validarFormatoCPF(Long cpf) {
        String cpfStr = String.valueOf(cpf);
        cpfStr = cpfStr.replaceAll("[^0-9]", "");
        return cpfStr.length() == 11 || cpfStr.length() == 0;
    }

    private static boolean validarFormatoTelefone(Long telefone) {
        // Remove qualquer caractere não numérico
        String numeroLimpo = String.valueOf(telefone).replaceAll("[^0-9]", "");
        // Verifica se o número de caracteres está entre 9 e 11
        return (numeroLimpo.length() >= 9 && numeroLimpo.length() <= 11) || numeroLimpo.length() == 0;
    }

    // Método para validar o formato da entrada (máximo 10 caracteres, permitindo
    // números e até 1 letra)
    private boolean validarFormatoNumero(String numero) {
        // Expressão regular para validar o formato da entrada
        String regex = "^[0-9]*[a-zA-Z]?[0-9]*$";
        // Remove todos os espaços em branco
        numero = numero.replaceAll("\\s", "");
        // Verifica se a entrada corresponde à expressão regular
        return numero.matches(regex) || numero.length() == 0;
    }

    // Método para validar a quantidade de caracteres
    private boolean validarFormatoCEP(Integer cep) {
        String cepStr = String.valueOf(cep);
        cepStr = cepStr.replaceAll("[^0-9]", "");
        return cepStr.length() == 8 || cepStr.length() == 0;
    }

    private boolean validarFormatoSenha(String senha) {
        return senha.length() <= 24 || senha.length() > 0;
    }
}
