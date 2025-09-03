package Modelos;

public class Usuario {
    private int id;
    private String nome;
    private String cpf;
    private boolean administrador;

    public Usuario(int id, String nome, String cpf, boolean administrador) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.administrador = administrador;
    }

    public Usuario(String nome, String cpf, boolean administrador) {
        this.nome = nome;
        this.cpf = cpf;
        this.administrador = administrador;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public boolean isAdministrador() { return administrador; }

    public void setId(int id) { this.id = id; }
    public void setNome(String nome) { this.nome = nome; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public void setAdministrador(boolean administrador) { this.administrador = administrador; }
}
