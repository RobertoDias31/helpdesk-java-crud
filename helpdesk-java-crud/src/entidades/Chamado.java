package entidades;

public class Chamado {
    private int id;
    private String descricao;

    public Chamado(int id, String descricao){
        this.id = id;
        this.descricao = descricao;
    }

    public int getId(){
        return id;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString(){
        return id + " --> " + descricao;
    }


}
