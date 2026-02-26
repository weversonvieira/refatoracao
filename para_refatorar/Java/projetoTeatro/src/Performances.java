import java.util.Objects;

public class Performances {

    private Atores atores;
    private Integer audience;

    public Atores getAtores() {
        return atores;
    }

    public void setAtores(Atores atores) {
        this.atores = atores;
    }

    public Integer getAudience() {
        return audience;
    }

    public void setAudience(Integer audience) {
        this.audience = audience;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Performances that = (Performances) o;
        return Objects.equals(atores, that.atores) && Objects.equals(audience, that.audience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(atores, audience);
    }
}
