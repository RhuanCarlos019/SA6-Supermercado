package main.control;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.dao.EstoquesDAO;
import main.model.Estoque;

public class EstoquesController {
    // -----===| ATRIBUTOS |===-----//
    private EstoquesDAO estoquesDAO = new EstoquesDAO();
    private List<Estoque> estoques;
    private DefaultTableModel tableModel;
    private JTable table;

    // -----===| CONSTRUTOR |===-----//
    public EstoquesController(List<Estoque> estoques, DefaultTableModel tableModel, JTable table) {
        this.estoques = estoques;
        this.tableModel = tableModel;
        this.table = table;
    }

    // -----===| MÉTODOS CRUD |===-----//
    // ---=| CREATE |=---//
    public void createEstoque(Short codigoProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor, Double precoProduto, Integer quantidadeProduto, Double descontoVip, Boolean statusProduto) {
        try {
            estoquesDAO.create(codigoProduto, nomeProduto, descricaoProduto, nomeFornecedor, precoProduto, quantidadeProduto, descontoVip, statusProduto);

            Estoque estoque = new Estoque(codigoProduto, nomeProduto, descricaoProduto, nomeFornecedor, precoProduto, quantidadeProduto, descontoVip, statusProduto);
            estoques.add(estoque);

            atualizarTabela();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---=| UPDATE |=---//
    public void updateEstoque(int linhaSelecionada, Short codigoProduto, String nomeProduto, String descricaoProduto, String nomeFornecedor, Double precoProduto, Integer quantidadeProduto, Double descontoVip, Boolean statusProduto) {
        if (linhaSelecionada != -1) {
            try {
                estoquesDAO.update(codigoProduto, nomeProduto, descricaoProduto, nomeFornecedor, precoProduto, quantidadeProduto, descontoVip, statusProduto);
                
                Estoque estoque = new Estoque(codigoProduto, nomeProduto, descricaoProduto, nomeFornecedor, precoProduto, quantidadeProduto, descontoVip, statusProduto);
                estoques.set(linhaSelecionada, estoque);
    
                atualizarTabela();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // ---=| DELETE |=---//
    public void inativarEstoque(int linhaSelecionada, Short codigoProduto) {
        try {
            if(linhaSelecionada != 1){
                estoquesDAO.inativar(codigoProduto);
                estoques.remove(linhaSelecionada);
                
                atualizarTabela();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ---=| Atualizar Tabela |=---//
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        Object linha[] = new Object[8];
        for (int i = 0; i < estoques.size(); i++) {
            linha[0] = estoques.get(i).getCodigoProduto();
            linha[1] = estoques.get(i).getNomeProduto();
            linha[2] = estoques.get(i).getDescricaoProduto();
            linha[3] = estoques.get(i).getNomeFornecedor();
            linha[4] = estoques.get(i).getPrecoProduto();
            linha[5] = estoques.get(i).getQuantidadeProduto();
            linha[6] = estoques.get(i).getDescontoVip();
            linha[7] = estoques.get(i).getStatusProduto();
        }
    }

    // ---=| CHECAGEM DE CAMPO |=---//
    public boolean checkEstoqueCampos(int linhaSelecionada, String operacao, String codigo, String nomeProduto, String descricao, String nomeFornecedor, String preco, String quantidade, String descontoVip, Boolean status){
        // Verifica se os campos estão preenchidos
        if (codigo.isEmpty() || nomeProduto.isEmpty() || descricao.isEmpty() || nomeFornecedor.isEmpty() || preco.isEmpty() || quantidade.isEmpty() || descontoVip.isEmpty()) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO!\nCampos obrigatórios estão em branco");
            return false;
        }
        if(!validarFormatoCodigo(codigo)){
            JOptionPane.showMessageDialog(null, "Código inválido!\nO Código do Produto deve conter apenas números e ter 3 dígitos!");
            return false;
        }
        if(!validarFormatoPreco(preco)){
            JOptionPane.showMessageDialog(null, "Preço inválido!\nO Preço deve conter até no máximo 2 casas decimais e deve ser positivo!");
            return false;
        }
        if(!validarFormatoQuantidade(quantidade)){
            JOptionPane.showMessageDialog(null, "Quantidade inválidoa\nA quantidade deve apenas números positivos!");
            return false;
        }
        if(!validarFormatoDescontoVip(descontoVip)){
            JOptionPane.showMessageDialog(null, "Desconto VIP inválido!\nO Desconto VIP deve conter apenas números positivos e ter até 3 casas decimais!");
            return false;
        }

        if(operacao.equals("cadastrar")){
            int resposta = JOptionPane.showConfirmDialog(null,"Realizar cadastro?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Executa a operação de cadastrar
                createEstoque(Short.valueOf(codigo.trim()), nomeProduto.trim(), descricao.trim(), nomeFornecedor.trim(), Double.valueOf(preco.trim()), Integer.valueOf(quantidade.trim()), Double.valueOf(descontoVip.trim()), status);
            }
        }
        else if(operacao.equals("atualizar")){
            int resposta = JOptionPane.showConfirmDialog(null,"Realizar edição?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Executa a operação de editar
                updateEstoque(linhaSelecionada, Short.valueOf(codigo.trim()), nomeProduto.trim(), descricao.trim(), nomeFornecedor.trim(), Double.valueOf(preco.trim()), Integer.valueOf(quantidade.trim()), Double.valueOf(descontoVip.trim()), status);
            }
        }
        else{
            int resposta = JOptionPane.showConfirmDialog(null,"Realizar inativação?", "Confirmação", JOptionPane.YES_NO_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                // Executa a opção de deletar
                inativarEstoque(linhaSelecionada, Short.valueOf(codigo.trim()));
            }
        }
        return true;
    }

    // Método para validar o formato do Código
    private boolean validarFormatoCodigo(String codigo) {
        // Verificar se a string tem exatamente 3 dígitos e é um número inteiro
        return codigo.matches("\\d{3}");
    }

    // Método para validar o formato do preço
    private boolean validarFormatoPreco(String preco) {
        // Expressão regular para validar o preço (até duas casas decimais)
        String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
        // Verifica se o preço corresponde à expressão regular
        return preco.matches(regex);
    }

    // Método para validar o formato da quantidade
    private boolean validarFormatoQuantidade(String quantidade) {
        // Expressão regular para validar a quantidade (números positivos)
        String regex = "^[1-9][0-9]*$";
        // Verifica se a quantidade corresponde à expressão regular
        return quantidade.matches(regex);
    }

    // Método para validar o formato do desconto VIP
    private boolean validarFormatoDescontoVip(String descontoVip) {
        // Expressão regular para validar o desconto VIP (até três casas decimais, números positivos)
        String regex = "^[0-9]+(\\.[0-9]{1,3})?$";
        // Verifica se o desconto VIP corresponde à expressão regular
        return descontoVip.matches(regex);
    }
}
