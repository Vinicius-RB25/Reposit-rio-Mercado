package telas;

import javax.swing.*;
import java.awt.*;

public class TelaInicial extends JFrame {

    public TelaInicial() {
        setTitle("Bem-vindo");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);

        JLabel pergunta = new JLabel("Você já possui login?");
        pergunta.setFont(new Font("Arial", Font.BOLD, 16));
        pergunta.setBounds(108, 32, 178, 30);
        getContentPane().add(pergunta);

        JButton simButton = new JButton("Sim");
        simButton.setBounds(80, 100, 100, 40);
        getContentPane().add(simButton);

        JButton naoButton = new JButton("Não");
        naoButton.setBounds(220, 100, 100, 40);
        getContentPane().add(naoButton);

        simButton.addActionListener(e -> {
            new TelaLogin().setVisible(true);
            dispose();
        });

        naoButton.addActionListener(e -> {
            new CadastroUsuario().setVisible(true);
            dispose();
        });

        setVisible(true);
    }
}
