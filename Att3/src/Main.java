import java.util.List;
import java.util.ArrayList;

class Livros{
    private String titulo;
    private List<autores> autores;

    public Livros(String titulo, List<autores> autores) {
        this.titulo = titulo;
        this.autores = autores;
    }

    public void showAutores() {
        System.out.println("Título: " + titulo);
        System.out.println("Autores:");
        for (autores autor : autores) {
            System.out.println("- " + autor.getNome());
        }
    }
}

class autores{
    private String nome_autor;

    public autores(String nome_autor) {
        this.nome_autor = nome_autor;
    }

    public String getNome() {
        return nome_autor;
    }
}

public class Main {
    public static void main(String[] args) {

        autores autor1 = new autores("Arthur");
        autores autor2 = new autores("Claudio");

        List<autores> listaAutores = new ArrayList<>();
        listaAutores.add(autor1);
        listaAutores.add(autor2);
        listaAutores.add(new autores("Jooj"));

        Livros livro = new Livros("Livro épico sobre java", listaAutores);

        livro.showAutores();

    }
}