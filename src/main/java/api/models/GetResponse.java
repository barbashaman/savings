package api.models;

import java.util.List;

public class GetResponse {
    private String id;
    private List<String> meses;
    private List<String> valor;

    public GetResponse() {
    }

    public GetResponse(String id, List<String> meses, List<String> valor) {
        this.id = id;
        this.meses = meses;
        this.valor = valor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getMeses() {
        return meses;
    }

    public void setMeses(List<String> meses) {
        this.meses = meses;
    }

    public List<String> getValor() {
        return valor;
    }

    public void setValor(List<String> valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "GetResponse{" +
                "id='" + id + '\'' +
                ", meses=" + meses +
                ", valor=" + valor +
                '}';
    }
}
