package model.grafo;

public class Vertice {
    private Integer id;
    private Double latitude;
    private Double longitude;
    private String descricao;

    public Vertice(Integer id, Double latitude, Double longitude, String descricao) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public int hashCode() {
        int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + (id == null ? 0 : id.hashCode());
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        Vertice outro = (Vertice) obj;
        if (id == null) {
            if (outro.id != null) {
                return false;
            }
        } else if (!id.equals(outro.id)) {
            return false;
        }
        return true;
    }
}
