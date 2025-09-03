package telas;

import javax.swing.*;
import java.awt.*;

public class Despedida extends JFrame {

    public Despedida(String nomeUsuario, double total) {
        setTitle("Obrigado!");
        setSize(400, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel mensagem = new JLabel(
                "<html>Obrigado, <b>" + nomeUsuario + "</b>!<br/>" +
                "O valor total da sua compra foi: R$ " + total + "<br/><br/>Volte sempre!</html>"
        );
        mensagem.setFont(new Font("Arial", Font.PLAIN, 16));
        mensagem.setBounds(50, 50, 300, 150);
        add(mensagem);

        setVisible(true);
    }
}
