package telas;

import Modelos.Produto;
import Modelos.Usuario;
import dao.CompraDAO;
import dao.ProdutoDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCompra extends JFrame {

    public TelaCompra(Usuario usuario) {
        setTitle("Compra");
        setSize(700, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        DefaultListModel<Produto> listaModel = new DefaultListModel<>();
        JList<Produto> lista = new JList<>(listaModel);
        lista.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(30, 30, 450, 400);
        add(scroll);

        JButton comprarButton = new JButton("Comprar");
        comprarButton.setFont(new Font("Arial", Font.BOLD, 14));
        comprarButton.setBounds(500, 50, 150, 50);
        add(comprarButton);

        JButton concluirButton = new JButton("Concluir Compra");
        concluirButton.setFont(new Font("Arial", Font.BOLD, 14));
        concluirButton.setBounds(500, 120, 150, 50);
        add(concluirButton);

        JLabel totalLabel = new JLabel("Total: 0.0");
        totalLabel.setFont(new Font("Arial", Font.BOLD, 16));
        totalLabel.setBounds(500, 190, 200, 40);
        add(totalLabel);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listar();
        for (Produto p : produtos) listaModel.addElement(p);

        CompraDAO compraDAO = new CompraDAO();
        final double[] total = {0};

        comprarButton.addActionListener(e -> {
            Produto sel = lista.getSelectedValue();
            if (sel != null) {
                total[0] += sel.getPreco();
                compraDAO.registrarCompra(usuario.getId(), sel.getId(), 1);
                JOptionPane.showMessageDialog(this,
                        "Comprado: " + sel.getNome() + "\nPreço: " + sel.getPreco());
                totalLabel.setText("Total: " + total[0]);
            }
        });

        concluirButton.addActionListener(e -> {
            new Despedida(usuario.getNome(), total[0]).setVisible(true);
            dispose();
        });

        setVisible(true);
    }
}
