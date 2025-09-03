package telas;

import Modelos.Usuario;
import dao.UsuarioDAO;

import javax.swing.*;
import java.awt.*;

public class TelaLogin extends JFrame {

    public TelaLogin() {
        setTitle("Login");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lNome = new JLabel("Nome:");
        lNome.setFont(new Font("Arial", Font.PLAIN, 16));
        lNome.setBounds(50, 50, 120, 40);
        add(lNome);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(200, 50, 300, 40);
        add(nomeField);

        JLabel lCpf = new JLabel("CPF:");
        lCpf.setFont(new Font("Arial", Font.PLAIN, 16));
        lCpf.setBounds(50, 120, 120, 40);
        add(lCpf);

        JTextField cpfField = new JTextField();
        cpfField.setBounds(200, 120, 300, 40);
        add(cpfField);

        JCheckBox adminCheck = new JCheckBox("Administrador");
        adminCheck.setFont(new Font("Arial", Font.PLAIN, 14));
        adminCheck.setBounds(200, 190, 200, 40);
        add(adminCheck);

        JButton entrarButton = new JButton("Entrar");
        entrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        entrarButton.setBounds(150, 260, 120, 50);
        add(entrarButton);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setBounds(320, 260, 150, 50);
        add(cadastrarButton);

        entrarButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String cpf = cpfField.getText().trim();

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario usuario = usuarioDAO.autenticar(nome, cpf);

            if (usuario != null) {
                if (usuario.isAdministrador()) {
                    new TelaCadastroP().setVisible(true);
                } else {
                    new TelaCompra(usuario).setVisible(true);
                }
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        cadastrarButton.addActionListener(e -> {
            new CadastroUsuario().setVisible(true);
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
