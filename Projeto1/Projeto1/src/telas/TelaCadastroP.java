package telas;

import javax.swing.*;

public class TelaCadastroP extends JFrame {
    public TelaCadastroP(Mercado mercado) {
        setTitle("Cadastro de Produtos");
        setSize(700, 500);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultListModel<Produto> listaModel = new DefaultListModel<>();
        JList<Produto> lista = new JList<>(listaModel);
        JScrollPane scroll = new JScrollPane(lista);
        scroll.setBounds(30, 30, 400, 350);
        add(scroll);

        JButton addButton = new JButton("Adicionar");
        addButton.setBounds(450, 50, 200, 50);
        add(addButton);

        JButton removerButton = new JButton("Remover");
        removerButton.setBounds(450, 120, 200, 50);
        add(removerButton);

        JButton logoutButton = new JButton("Deslogar");
        logoutButton.setBounds(450, 190, 200, 50);
        add(logoutButton);

        for (Produto p : mercado.getProdutos()) listaModel.addElement(p);

        addButton.addActionListener(e -> {
            String nome = JOptionPane.showInputDialog("Nome do produto:");
            if (nome == null || nome.isEmpty()) return;
            double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));
            mercado.adicionarProduto(new Produto(nome, preco));
            listaModel.clear();
            for (Produto p : mercado.getProdutos()) listaModel.addElement(p);
        });

        removerButton.addActionListener(e -> {
            Produto sel = lista.getSelectedValue();
            if (sel != null) {
                mercado.removerProduto(sel);
                listaModel.clear();
                for (Produto p : mercado.getProdutos()) listaModel.addElement(p);
            }
        });

        logoutButton.addActionListener(e -> {
            new TelaLogin(mercado);
            setVisible(false);
        });

        setVisible(true);
    }
}


