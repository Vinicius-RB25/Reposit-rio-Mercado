package telas;

import javax.swing.*;

public class TelaCompra extends JFrame {
    public TelaCompra(Mercado mercado, String nome, String cpf) {
        setTitle("Compra");
        setSize(700, 550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultListModel<Produto> listaModel = new DefaultListModel<>();
        JList<Produto> lista = new JList<>(listaModel);
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(30, 30, 450, 400);
        add(scroll);

        JButton comprarButton = new JButton("Comprar");
        comprarButton.setBounds(500, 50, 150, 50);
        add(comprarButton);

        JLabel totalLabel = new JLabel("Total: 0.0");
        totalLabel.setBounds(500, 120, 150, 40);
        add(totalLabel);

        for (Produto p : mercado.getProdutos()) listaModel.addElement(p);

        final double[] total = {0};
        comprarButton.addActionListener(e -> {
            Produto sel = lista.getSelectedValue();
            if (sel != null) {
                total[0] += sel.getPreco();
                JOptionPane.showMessageDialog(this,
                        "Comprado: " + sel.getNome() + "\nPreço: " + sel.getPreco());
                totalLabel.setText("Total: " + total[0]);
            }
        });

        setVisible(true);
    }
}

