package caixaeletronico;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaPrincipalGUI extends JFrame {
    private static final long serialVersionUID = 1L;

    private double saldo = 0.0;  // Saldo inicial
    private JTextField valorField;  // Campo para entrada de valores
    private JTextArea areaSaldo;  // Área de texto para exibir saldo

    public TelaPrincipalGUI() {
        setTitle("Bem-vindo ao Caixa Eletrônico");
        
        // Definindo o tamanho da janela
        setSize(600, 400);
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);  // Define um espaçamento entre os componentes
        
        // Configurando uma fonte mais legível
        Font fontePadrao = new Font("Arial", Font.PLAIN, 18);

        // Criando e configurando os elementos da interface
        JLabel tituloLabel = new JLabel("Bem-vindo ao Caixa Eletrônico");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 22));  // Título em negrito
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;  // O título ocupa duas colunas
        add(tituloLabel, gbc);
        
        // Botão para consultar saldo
        JButton saldoButton = new JButton("Consultar Saldo");
        saldoButton.setFont(fontePadrao);
        gbc.gridwidth = 1;  // Reseta para uma coluna
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(saldoButton, gbc);

        // Botão para depósito
        JButton depositoButton = new JButton("Depositar");
        depositoButton.setFont(fontePadrao);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(depositoButton, gbc);

        // Botão para saque
        JButton saqueButton = new JButton("Sacar");
        saqueButton.setFont(fontePadrao);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(saqueButton, gbc);
        
        // Campo de entrada para valores
        valorField = new JTextField(10);
        valorField.setFont(fontePadrao);
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(valorField, gbc);

        // Área de texto para exibir o saldo
        areaSaldo = new JTextArea(5, 20);
        areaSaldo.setFont(fontePadrao);
        areaSaldo.setEditable(false);  // Não permite edição na área de saldo
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridheight = 2;  // Ocupa duas linhas
        JScrollPane scroll = new JScrollPane(areaSaldo); // Adiciona barra de rolagem
        scroll.setPreferredSize(new Dimension(300, 100)); // Define o tamanho da barra de rolagem
        add(scroll, gbc);

        // Adicionando ações aos botões
        saldoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarSaldo();  // Chama o método para consultar saldo
            }
        });

        depositoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarDeposito();  // Chama o método para realizar depósito
            }
        });

        saqueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarSaque();  // Chama o método para realizar saque
            }
        });

        setVisible(true);  // Torna a janela visível
    }

    // Método para consultar o saldo
    private void consultarSaldo() {
        areaSaldo.setText("Seu saldo atual é: R$ " + saldo);  // Exibe o saldo na área de texto
    }

    // Método para realizar depósito
    private void realizarDeposito() {
        double valor = Double.parseDouble(valorField.getText());  // Lê o valor do campo
        if (valor >= 20) {  // Verifica se o valor é maior ou igual a R$ 20
            saldo += valor;  // Atualiza o saldo
            areaSaldo.setText("Depósito de R$ " + valor + " realizado com sucesso.");
        } else {
            areaSaldo.setText("O valor mínimo para depósito é R$ 20.");
        }
        valorField.setText("");  // Limpa o campo após a operação
    }

    // Método para realizar saque
    private void realizarSaque() {
        double valor = Double.parseDouble(valorField.getText());  // Lê o valor do campo
        if (valor >= 10 && valor <= saldo) {  // Verifica se o valor é válido para saque
            saldo -= valor;  // Atualiza o saldo
            areaSaldo.setText("Saque de R$ " + valor + " realizado com sucesso.");
        } else if (valor < 10) {
            areaSaldo.setText("O valor mínimo para saque é R$ 10.");
        } else {
            areaSaldo.setText("Saldo insuficiente.");
        }
        valorField.setText("");  // Limpa o campo após a operação
    }

    // Método principal para iniciar a aplicação
    public static void main(String[] args) {
        new TelaPrincipalGUI();  // Inicia a tela principal do caixa eletrônico
    }
}
