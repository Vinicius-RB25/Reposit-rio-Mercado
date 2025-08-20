package telas;

import javax.swing.*;

public class TelaLogin extends JFrame {
    public TelaLogin(Mercado mercado) {
        setTitle("Login");
        setSize(600, 400);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lNome = new JLabel("Nome:");
        lNome.setBounds(50, 50, 120, 40);
        add(lNome);
        JTextField nomeField = new JTextField();
        nomeField.setBounds(200, 50, 300, 40);
        add(nomeField);

        JLabel lCpf = new JLabel("CPF:");
        lCpf.setBounds(50, 120, 120, 40);
        add(lCpf);
        JTextField cpfField = new JTextField();
        cpfField.setBounds(200, 120, 300, 40);
        add(cpfField);

        JCheckBox adminCheck = new JCheckBox("Administrador");
        adminCheck.setBounds(200, 190, 200, 40);
        add(adminCheck);

        JButton entrarButton = new JButton("Entrar");
        entrarButton.setBounds(250, 260, 120, 50);
        add(entrarButton);

        entrarButton.addActionListener(e -> {
            if (adminCheck.isSelected()) {
                new TelaCadastroP(mercado).setVisible(true);
            } else {
                new TelaCompra(mercado, nomeField.getText(), cpfField.getText()).setVisible(true);
            }
            setVisible(false);
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaLogin(new Mercado());
    }
}
