package com.exemplo.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EstoquesView extends JFrame {
    private JPanel panel;
    private JLabel labelCodigoProduto, labelNomeProduto, labelDescricaoProduto, labelNomeFornecedor, labelPrecoProduto, labelQuantidadeProduto, labelDescontoVip, labelStatusProduto;
    private JTextField fieldCodigoProduto, fieldNomeProduto, fieldDescricaoProduto, fieldNomeFornecedor, fieldPrecoProduto, fieldQuantidadeProduto, fieldDescontoVip;
    private JButton btnCadastrarProduto, btnAtualizarProduto, btnInativarProduto;
    private JTable tableEstoques;

    public EstoquesView() {
        // Configurações básicas da janela
        setTitle("Estoques View");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Inicializa os componentes da interface
        initializeComponents();

        // Adiciona os componentes ao painel
        addComponentsToPanel();

        // Adiciona o painel à janela
        add(panel);
    }

    private void initializeComponents() {
        // Inicializa os componentes
        panel = new JPanel();
        labelCodigoProduto = new JLabel("Código Produto:");
        labelNomeProduto = new JLabel("Nome Produto:");
        labelDescricaoProduto = new JLabel("Descrição Produto:");
        labelNomeFornecedor = new JLabel("Nome Fornecedor:");
        labelPrecoProduto = new JLabel("Preço Produto:");
        labelQuantidadeProduto = new JLabel("Quantidade Produto:");
        labelDescontoVip = new JLabel("Desconto VIP:");
        labelStatusProduto = new JLabel("Status Produto:");

        fieldCodigoProduto = new JTextField(15);
        fieldNomeProduto = new JTextField(15);
        fieldDescricaoProduto = new JTextField(15);
        fieldNomeFornecedor = new JTextField(15);
        fieldPrecoProduto = new JTextField(15);
        fieldQuantidadeProduto = new JTextField(15);
        fieldDescontoVip = new JTextField(15);

        btnCadastrarProduto = new JButton("Cadastrar Produto");
        btnAtualizarProduto = new JButton("Atualizar Produto");
        btnInativarProduto = new JButton("Inativar Produto");

        // Inicializa a tabela de estoques
        tableEstoques = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Código Produto", "Nome Produto", "Descrição Produto", "Nome Fornecedor", "Preço Produto", "Quantidade Produto", "Desconto VIP", "Status Produto"}
        ));
    }

    private void addComponentsToPanel() {
        // Adiciona os componentes ao painel
        panel.add(labelCodigoProduto);
        panel.add(fieldCodigoProduto);

        panel.add(labelNomeProduto);
        panel.add(fieldNomeProduto);

        panel.add(labelDescricaoProduto);
        panel.add(fieldDescricaoProduto);

        panel.add(labelNomeFornecedor);
        panel.add(fieldNomeFornecedor);

        panel.add(labelPrecoProduto);
        panel.add(fieldPrecoProduto);

        panel.add(labelQuantidadeProduto);
        panel.add(fieldQuantidadeProduto);

        panel.add(labelDescontoVip);
        panel.add(fieldDescontoVip);

        panel.add(btnCadastrarProduto);
        panel.add(btnAtualizarProduto);
        panel.add(btnInativarProduto);

        panel.add(labelStatusProduto);

        panel.add(tableEstoques.getTableHeader());
        panel.add(tableEstoques);
    }

    // Métodos para obter os dados da interface
    public Short obterCodigoProduto() {
        return Short.valueOf(fieldCodigoProduto.getText());
    }

    public String obterNomeProduto() {
        return fieldNomeProduto.getText();
    }

    // Implemente os métodos para obter os outros dados da interface, se necessário

    // Métodos para atualizar a tabela de estoques
    public void atualizarTabela(Object[][] data) {
        DefaultTableModel model = (DefaultTableModel) tableEstoques.getModel();
        model.setRowCount(0); // Limpa a tabela

        // Adiciona as linhas na tabela
        for (Object[] row : data) {
            model.addRow(row);
        }
    }

    // Métodos para exibir mensagens
    public void exibirMensagem(String mensagem) {
        // Implemente a lógica para exibir mensagens na interface
    }

    public void exibirMensagemErro(String mensagemErro) {
        // Implemente a lógica para exibir mensagens de erro na interface
    }

    // Métodos para definir ações nos botões
    public void definirAcaoCadastrarProduto(ActionListener actionListener) {
        btnCadastrarProduto.addActionListener(actionListener);
    }

    public void definirAcaoAtualizarProduto(ActionListener actionListener) {
        btnAtualizarProduto.addActionListener(actionListener);
    }

    public void definirAcaoInativarProduto(ActionListener actionListener) {
        btnInativarProduto.addActionListener(actionListener);
    }
}
