package main.control;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.dao.ClientesDAO;
import main.model.Cliente;

public class ClienteController {
    // -----===| ATRIBUTOS |===-----//
    private ClientesDAO clientesDAO = new ClientesDAO();
    private List<Cliente> clientes;
    private DefaultTableModel tableModel;
    private JTable table;

    // -----===| CONSTRUTOR |===-----//
    public ClienteController(List<Cliente> clientes, DefaultTableModel tableModel, JTable table) {
        this.clientes = clientes;
        this.tableModel = tableModel;
        this.table = table;
    }

    // -----===| MÉTODOS CRUD |===-----//
    // ---=| CREATE |=---//
    public void createCliente(Long cpfCliente, String nomeCliente, Long telefoneCliente,
            String ruaCliente, String numeroCliente, Integer cepCliente) {
        try {
            clientesDAO.create(cpfCliente, nomeCliente, telefoneCliente, ruaCliente,
                    numeroCliente, cepCliente);

            Cliente cliente = new Cliente(cpfCliente, nomeCliente, telefoneCliente,
                    ruaCliente, numeroCliente, cepCliente);
            clientes.add(cliente);

            atualizarTabela();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---=| UPDATE |=---//
    public void updateCliente(int linhaSelecionada, Long cpfCliente, String nomeCliente,
            Long telefoneCliente, String ruaCliente, String numeroCliente, Integer cepCliente) {
        if (linhaSelecionada != -1) {
            try {
                clientesDAO.update(cpfCliente, nomeCliente, telefoneCliente, ruaCliente, numeroCliente, cepCliente);

                Cliente cliente = new Cliente(cpfCliente, nomeCliente, telefoneCliente, ruaCliente, numeroCliente, cepCliente);
                clientes.set(linhaSelecionada, cliente);

                atualizarTabela();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ---=| DELETE |=---//
    public void deleteCliente(int linhaSelecionada, Long cpfCliente) {
        try {
            if (linhaSelecionada != -1) {
                clientesDAO.delete(cpfCliente);
                clientes.remove(linhaSelecionada);

                atualizarTabela();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---=| Atualizar Tabela |=---//
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        Object linha[] = new Object[6];
        for (int i = 0; i < clientes.size(); i++) {
            linha[0] = clientes.get(i).getCpfCliente();
            linha[1] = clientes.get(i).getNomeCliente();
            linha[2] = clientes.get(i).getTelefoneCliente();
            linha[3] = clientes.get(i).getRuaCliente();
            linha[4] = clientes.get(i).getNumeroCliente();
            linha[5] = clientes.get(i).getCepCliente();
            tableModel.addRow(linha);
        }
    }

    public boolean checkClienteCampos(int linhaSelecionada, String operacao, String cpf, String nome, String telefone, String rua, String numero, String cep) {
        // Verifica se os campos estão preenchidos
        if (cpf.isEmpty() || nome.isEmpty()) {
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

        if (operacao.equals("cadastrar")) {
            int resposta = JOptionPane.showConfirmDialog(null, "Realizar cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Evitar problemas de conversão (Long/Integer para String)
                telefone = (telefone.isEmpty()) ? "0" : telefone;
                cep = (cep.isEmpty()) ? "0" : cep;

                // Executa a operação de cadastrar
                createCliente(Long.valueOf(cpf.trim()), nome.trim(), Long.valueOf(telefone.trim()), rua.trim(), numero.trim(), Integer.valueOf(cep.trim()));
            }
        } else if (operacao.equals("atualizar")) {
            int resposta = JOptionPane.showConfirmDialog(null, "Realizar edição?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Evitar problemas de conversão (Long/Integer para String)
                telefone = (telefone.isEmpty()) ? "0" : telefone;
                cep = (cep.isEmpty()) ? "0" : cep;

                // Executa a operação de editar
                updateCliente(linhaSelecionada, Long.valueOf(cpf.trim()), nome.trim(), Long.valueOf(telefone.trim()), rua.trim(), numero.trim(), Integer.valueOf(cep.trim()));
            }
        } else {
            int resposta = JOptionPane.showConfirmDialog(null, "Realizar exclusão?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Executa a opção de deletar
                deleteCliente(linhaSelecionada, Long.valueOf(cpf.trim()));
            }
        }
        return true;
    }

    private boolean validarFormatoCPF(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf.length() == 11 || cpf.isEmpty();
    }

    private static boolean validarFormatoTelefone(String telefone) {
        // Remove qualquer caractere não numérico
        String numeroLimpo = telefone.replaceAll("[^0-9]", "");
        // Verifica se o número de caracteres está entre 9 e 11
        return (numeroLimpo.length() >= 9 && numeroLimpo.length() <= 11) || numeroLimpo.isEmpty();
    }

    // Método para validar o formato da entrada (máximo 10 caracteres, permitindo
    // números e até 1 letra)
    private boolean validarFormatoNumero(String numero) {
        // Expressão regular para validar o formato da entrada
        String regex = "^[0-9]*[a-zA-Z]?[0-9]*$";
        // Remove todos os espaços em branco
        numero = numero.replaceAll("\\s", "");
        // Verifica se a entrada corresponde à expressão regular
        return numero.matches(regex) || numero.isEmpty();
    }

    // Método para validar a quantidade de caracteres
    private boolean validarFormatoCEP(String cep) {
        cep = cep.replaceAll("[^0-9]", "");
        return cep.length() == 8 || cep.isEmpty();
    }
}
