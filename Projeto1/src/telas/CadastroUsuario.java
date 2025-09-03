package telas;

import Modelos.Usuario;
import dao.UsuarioDAO;

import javax.swing.*;
import java.awt.*;

public class CadastroUsuario extends JFrame {

    public CadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(500, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lNome = new JLabel("Nome:");
        lNome.setFont(new Font("Arial", Font.PLAIN, 16));
        lNome.setBounds(50, 50, 100, 30);
        add(lNome);

        JTextField nomeField = new JTextField();
        nomeField.setBounds(180, 50, 250, 30);
        add(nomeField);

        JLabel lCpf = new JLabel("CPF:");
        lCpf.setFont(new Font("Arial", Font.PLAIN, 16));
        lCpf.setBounds(50, 100, 100, 30);
        add(lCpf);

        JTextField cpfField = new JTextField();
        cpfField.setBounds(180, 100, 250, 30);
        add(cpfField);

        JCheckBox adminCheck = new JCheckBox("Administrador");
        adminCheck.setFont(new Font("Arial", Font.PLAIN, 14));
        adminCheck.setBounds(180, 150, 200, 30);
        add(adminCheck);

        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("Arial", Font.BOLD, 16));
        cadastrarButton.setBounds(180, 200, 150, 40);
        add(cadastrarButton);

        cadastrarButton.addActionListener(e -> {
            String nome = nomeField.getText().trim();
            String cpf = cpfField.getText().trim();
            boolean administrador = adminCheck.isSelected();

            if (nome.isEmpty() || cpf.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha todos os campos!", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            Usuario usuario = new Usuario(nome, cpf, administrador);
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            boolean sucesso = usuarioDAO.inserir(usuario);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
                new TelaLogin().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar usuário!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });

        setVisible(true);
    }
}
