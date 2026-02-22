import java.util.Objects;

public class Atores {

    private String nome;
    private String tipo;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Atores atores = (Atores) o;
        return Objects.equals(nome, atores.nome) && Objects.equals(tipo, atores.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, tipo);
    }
}
