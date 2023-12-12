package com.exemplo.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClienteView extends JFrame {
    private JPanel panel;
    private JLabel labelCPF, labelNome, labelTelefone, labelRua, labelNumero, labelCEP, labelStatusVIP;
    private JTextField fieldCPF, fieldNome, fieldTelefone, fieldRua, fieldNumero, fieldCEP;
    private JButton btnVerificarVIP, btnCadastrarCliente;

    public ClienteView() {
        // Configurações básicas da janela
        setTitle("Cliente View");
        setSize(400, 300);
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
        labelCPF = new JLabel("CPF:");
        labelNome = new JLabel("Nome:");
        labelTelefone = new JLabel("Telefone:");
        labelRua = new JLabel("Rua:");
        labelNumero = new JLabel("Número:");
        labelCEP = new JLabel("CEP:");
        labelStatusVIP = new JLabel("Status VIP:");

        fieldCPF = new JTextField(15);
        fieldNome = new JTextField(15);
        fieldTelefone = new JTextField(15);
        fieldRua = new JTextField(15);
        fieldNumero = new JTextField(15);
        fieldCEP = new JTextField(15);

        btnVerificarVIP = new JButton("Verificar VIP");
        btnCadastrarCliente = new JButton("Cadastrar Cliente");
    }

    private void addComponentsToPanel() {
        // Adiciona os componentes ao painel
        panel.add(labelCPF);
        panel.add(fieldCPF);

        panel.add(labelNome);
        panel.add(fieldNome);

        panel.add(labelTelefone);
        panel.add(fieldTelefone);

        panel.add(labelRua);
        panel.add(fieldRua);

        panel.add(labelNumero);
        panel.add(fieldNumero);

        panel.add(labelCEP);
        panel.add(fieldCEP);

        panel.add(btnVerificarVIP);
        panel.add(btnCadastrarCliente);

        panel.add(labelStatusVIP);
    }

    // Métodos para obter os dados da interface
    public String obterCPF() {
        return fieldCPF.getText();
    }

    public String obterNome() {
        return fieldNome.getText();
    }

    // Implemente os métodos para obter os outros dados da interface, se necessário

    // Métodos para atualizar a interface
    public void exibirStatusVIP(boolean vip) {
        labelStatusVIP.setText("Status VIP: " + (vip ? "Sim" : "Não"));
    }

    public void exibirMensagem(String mensagem) {
        // Implemente a lógica para exibir mensagens na interface
    }

    public void exibirMensagemErro(String mensagemErro) {
        // Implemente a lógica para exibir mensagens de erro na interface
    }

    // Métodos para definir ações nos botões
    public void definirAcaoVerificarVIP(ActionListener actionListener) {
        btnVerificarVIP.addActionListener(actionListener);
    }

    public void definirAcaoCadastrarCliente(ActionListener actionListener) {
        btnCadastrarCliente.addActionListener(actionListener);
    }
}
