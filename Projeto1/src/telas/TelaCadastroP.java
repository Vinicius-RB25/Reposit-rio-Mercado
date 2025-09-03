package telas;

import Modelos.Produto;
import Modelos.Usuario;
import dao.ProdutoDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaCadastroP extends JFrame {

    public TelaCadastroP() {
        setTitle("Cadastro de Produtos");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        DefaultListModel<Produto> listaModel = new DefaultListModel<>();
        JList<Produto> lista = new JList<>(listaModel);
        lista.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(30, 30, 400, 350);
        add(scroll);

        JButton addButton = new JButton("Adicionar");
        addButton.setFont(new Font("Arial", Font.BOLD, 14));
        addButton.setBounds(450, 50, 200, 50);
        add(addButton);

        JButton removerButton = new JButton("Remover");
        removerButton.setFont(new Font("Arial", Font.BOLD, 14));
        removerButton.setBounds(450, 120, 200, 50);
        add(removerButton);

        JButton logoutButton = new JButton("Deslogar");
        logoutButton.setFont(new Font("Arial", Font.BOLD, 14));
        logoutButton.setBounds(450, 190, 200, 50);
        add(logoutButton);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        List<Produto> produtos = produtoDAO.listar();
        for (Produto p : produtos) listaModel.addElement(p);

        addButton.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome do produto:");
            if (nome == null || nome.isEmpty()) return;
            double preco;
            try {
                preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Preço inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            Produto p = new Produto(nome, preco);
            produtoDAO.inserir(p);
            listaModel.addElement(p);
        });

        removerButton.addActionListener(e -> {
            Produto sel = lista.getSelectedValue();
            if (sel != null) {
                produtoDAO.remover(sel.getId());
                listaModel.removeElement(sel);
            }
        });

        logoutButton.addActionListener(e -> {
            new TelaLogin().setVisible(true);
            dispose();
        });

        setVisible(true);
    }
}
