package caixaeletronico;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CaixaEletronicoGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField agenciaField;
    private JTextField contaField;
    private JPasswordField senhaField;

    public CaixaEletronicoGUI() {
        setTitle("Autenticação - Caixa Eletrônico");
        setSize(400, 300);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Define um espaçamento entre os componentes

        // Criando e configurando os elementos da interface
        JLabel agenciaLabel = new JLabel("Agência:");
        JLabel contaLabel = new JLabel("Conta:");
        JLabel senhaLabel = new JLabel("Senha Eletrônica:");
        agenciaField = new JTextField(20);
        contaField = new JTextField(20);
        senhaField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(agenciaLabel, gbc);
        gbc.gridx = 1;
        add(agenciaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(contaLabel, gbc);
        gbc.gridx = 1;
        add(contaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(senhaLabel, gbc);
        gbc.gridx = 1;
        add(senhaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(loginButton, gbc);

        // Adicionando ação ao botão de login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticar(); // Chama o método de autenticação
            }
        });

        setVisible(true); // Torna a janela visível
    }

    // Método para autenticar o usuário
    private void autenticar() {
        String agencia = agenciaField.getText();
        String conta = contaField.getText();
        String senha = new String(senhaField.getPassword());

        // Exemplo de verificação (substitua pelos valores corretos)
        if (agencia.equals("1234") && conta.equals("56789") && senha.equals("123456")) {
            // Se a autenticação for bem-sucedida, abre a TelaPrincipalGUI
            new TelaPrincipalGUI();
            dispose(); // Fecha a tela de autenticação
        } else {
            JOptionPane.showMessageDialog(this, "Agência, Conta ou Senha incorretos!", "Erro de Autenticação", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new CaixaEletronicoGUI(); // Inicia a tela de autenticação
    }
}
