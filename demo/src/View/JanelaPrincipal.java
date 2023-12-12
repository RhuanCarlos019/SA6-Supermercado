import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaPrincipal extends JFrame {
    private JTextField codigoBarrasField;
    private JTextField quantidadeField;
    private JTextArea produtosArea;
    private JButton btnIniciarVenda;
    private boolean vendaEmAndamento = false;
    private boolean clienteVip = false;

    public JanelaPrincipal() {
        setTitle("Sistema de Vendas");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Campos de entrada
        JPanel painelEntrada = new JPanel(new FlowLayout());
        codigoBarrasField = new JTextField(10);
        quantidadeField = new JTextField(5);
        JButton btnAdicionar = new JButton("Adicionar");
        btnIniciarVenda = new JButton("Iniciar Venda");

        painelEntrada.add(new JLabel("Código de Barras:"));
        painelEntrada.add(codigoBarrasField);
        painelEntrada.add(new JLabel("Quantidade:"));
        painelEntrada.add(quantidadeField);
        painelEntrada.add(btnAdicionar);
        painelEntrada.add(btnIniciarVenda);

        // Área de exibição dos produtos
        produtosArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(produtosArea);

        // Adiciona componentes ao painel principal
        painelPrincipal.add(painelEntrada, BorderLayout.NORTH);
        painelPrincipal.add(scrollPane, BorderLayout.CENTER);

        // Ação do botão "Iniciar Venda"
        btnIniciarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iniciarVenda();
            }
        });

        // Ação do botão "Adicionar"
        btnAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        // Adiciona o painel principal à janela
        add(painelPrincipal);
    }

    private void iniciarVenda() {
        int resposta = JOptionPane.showConfirmDialog(this, "O cliente é VIP?", "Cliente VIP", JOptionPane.YES_NO_OPTION);
        clienteVip = (resposta == JOptionPane.YES_OPTION);

        vendaEmAndamento = true;
        atualizarProdutos();
    }

    private void adicionarProduto() {
        if (!vendaEmAndamento) {
            JOptionPane.showMessageDialog(this, "A venda ainda não foi iniciada.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Lógica para adicionar produto à venda
        // ... (adicionar lógica de acordo com o seu projeto)

        atualizarProdutos();
    }

    private void atualizarProdutos() {
        // Lógica para atualizar a área de produtos com base na venda
        // ... (adicionar lógica de acordo com o seu projeto)
        produtosArea.setText("Produtos:\n");

        // Exemplo de exibição na área de produtos
        produtosArea.append("Produto 1 - R$ 10.00\n");
        produtosArea.append("Produto 2 - R$ 20.00\n");

        // Exemplo de desconto para cliente VIP
        if (clienteVip) {
            produtosArea.append("\nDesconto VIP: 10%\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
}
