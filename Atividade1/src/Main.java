class Usuario {
    private String login;
    private String senha;
    private String tipo;
    private static int totalUsuarios = 0;

    public Usuario(String login, String senha, String tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
        totalUsuarios++;
    }

    public String getLogin() {
        return this.login;
    }

    public String getTipo() {
        return this.tipo;
    }

    public static int getTotalUsuarios() {
        return totalUsuarios;
    }

    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}

public class Main {
    public static void main(String[] args) {
        Usuario usuario1 = new Usuario("joao123", "senha123", "comum");
        Usuario usuario2 = new Usuario("admin", "adminpass", "administrador");

        System.out.println("Total de usuários: " + Usuario.getTotalUsuarios());

        System.out.println("Autenticando joao123 com senha correta: " + usuario1.autenticar("joao123", "senha123"));
        System.out.println("Autenticando joao123 com senha errada: " + usuario1.autenticar("joao123", "errada"));

        usuario1.alterarSenha("novaSenha456");
        System.out.println("Autenticando joao123 com nova senha: " + usuario1.autenticar("joao123", "novaSenha456"));
    }
}
