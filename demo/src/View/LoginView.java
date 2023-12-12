package com.exemplo.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends JFrame {
    private JPanel panel;
    private JLabel labelUsuario, labelSenha;
    private JTextField fieldUsuario;
    private JPasswordField fieldSenha;
    private JButton btnLogin;

    public LoginView() {
        // Configurações básicas da janela
        setTitle("Login");
        setSize(400, 200);
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
        labelUsuario = new JLabel("Usuário:");
        labelSenha = new JLabel("Senha:");

        fieldUsuario = new JTextField(15);
        fieldSenha = new JPasswordField(15);

        btnLogin = new JButton("Login");
    }

    private void addComponentsToPanel() {
        // Adiciona os componentes ao painel
        panel.add(labelUsuario);
        panel.add(fieldUsuario);

        panel.add(labelSenha);
        panel.add(fieldSenha);

        panel.add(btnLogin);
    }

    // Métodos para obter os dados da interface
    public String obterUsuario() {
        return fieldUsuario.getText();
    }

    public String obterSenha() {
        return new String(fieldSenha.getPassword());
    }

    // Métodos para exibir mensagens
    public void exibirMensagem(String mensagem) {
        // Implemente a lógica para exibir mensagens na interface
    }

    public void exibirMensagemErro(String mensagemErro) {
        // Implemente a lógica para exibir mensagens de erro na interface
    }

    // Método para definir ação no botão de login
    public void definirAcaoLogin(ActionListener actionListener) {
        btnLogin.addActionListener(actionListener);
    }
}
