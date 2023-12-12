package com.exemplo.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FuncionariosView extends JFrame {
    private JPanel panel;
    private JLabel labelCpfFuncionario, labelNomeFuncionario, labelTelefoneFuncionario, labelRuaFuncionario, labelNumeroFuncionario, labelCepFuncionario, labelSenhaFuncionario, labelNivelAcessoFuncionario;
    private JTextField fieldCpfFuncionario, fieldNomeFuncionario, fieldTelefoneFuncionario, fieldRuaFuncionario, fieldNumeroFuncionario, fieldCepFuncionario, fieldSenhaFuncionario, fieldNivelAcessoFuncionario;
    private JButton btnCadastrarFuncionario, btnAtualizarFuncionario, btnExcluirFuncionario;
    private JTable tableFuncionarios;

    public FuncionariosView() {
        // Configurações básicas da janela
        setTitle("Funcionários View");
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
        labelCpfFuncionario = new JLabel("CPF Funcionário:");
        labelNomeFuncionario = new JLabel("Nome Funcionário:");
        labelTelefoneFuncionario = new JLabel("Telefone Funcionário:");
        labelRuaFuncionario = new JLabel("Rua Funcionário:");
        labelNumeroFuncionario = new JLabel("Número Funcionário:");
        labelCepFuncionario = new JLabel("CEP Funcionário:");
        labelSenhaFuncionario = new JLabel("Senha Funcionário:");
        labelNivelAcessoFuncionario = new JLabel("Nível de Acesso:");

        fieldCpfFuncionario = new JTextField(15);
        fieldNomeFuncionario = new JTextField(15);
        fieldTelefoneFuncionario = new JTextField(15);
        fieldRuaFuncionario = new JTextField(15);
        fieldNumeroFuncionario = new JTextField(15);
        fieldCepFuncionario = new JTextField(15);
        fieldSenhaFuncionario = new JTextField(15);
        fieldNivelAcessoFuncionario = new JTextField(15);

        btnCadastrarFuncionario = new JButton("Cadastrar Funcionário");
        btnAtualizarFuncionario = new JButton("Atualizar Funcionário");
        btnExcluirFuncionario = new JButton("Excluir Funcionário");

        // Inicializa a tabela de funcionários
        tableFuncionarios = new JTable(new DefaultTableModel(
                new Object[][]{},
                new String[]{"CPF Funcionário", "Nome Funcionário", "Telefone Funcionário", "Rua Funcionário", "Número Funcionário", "CEP Funcionário", "Senha Funcionário", "Nível de Acesso"}
        ));
    }

    private void addComponentsToPanel() {
        // Adiciona os componentes ao painel
        panel.add(labelCpfFuncionario);
        panel.add(fieldCpfFuncionario);

        panel.add(labelNomeFuncionario);
        panel.add(fieldNomeFuncionario);

        panel.add(labelTelefoneFuncionario);
        panel.add(fieldTelefoneFuncionario);

        panel.add(labelRuaFuncionario);
        panel.add(fieldRuaFuncionario);

        panel.add(labelNumeroFuncionario);
        panel.add(fieldNumeroFuncionario);

        panel.add(labelCepFuncionario);
        panel.add(fieldCepFuncionario);

        panel.add(labelSenhaFuncionario);
        panel.add(fieldSenhaFuncionario);

        panel.add(labelNivelAcessoFuncionario);
        panel.add(fieldNivelAcessoFuncionario);

        panel.add(btnCadastrarFuncionario);
        panel.add(btnAtualizarFuncionario);
        panel.add(btnExcluirFuncionario);

        panel.add(tableFuncionarios.getTableHeader());
        panel.add(tableFuncionarios);
    }

    // Métodos para obter os dados da interface
    public Long obterCpfFuncionario() {
        return Long.valueOf(fieldCpfFuncionario.getText());
    }

    public String obterNomeFuncionario() {
        return fieldNomeFuncionario.getText();
    }

    // Implemente os métodos para obter os outros dados da interface, se necessário

    // Métodos para atualizar a tabela de funcionários
    public void atualizarTabela(Object[][] data) {
        DefaultTableModel model = (DefaultTableModel) tableFuncionarios.getModel();
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
    public void definirAcaoCadastrarFuncionario(ActionListener actionListener) {
        btnCadastrarFuncionario.addActionListener(actionListener);
    }

    public void definirAcaoAtualizarFuncionario(ActionListener actionListener) {
        btnAtualizarFuncionario.addActionListener(actionListener);
    }

    public void definirAcaoExcluirFuncionario(ActionListener actionListener) {
        btnExcluirFuncionario.addActionListener(actionListener);
    }
}
