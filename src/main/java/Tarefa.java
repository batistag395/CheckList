import java.time.LocalDateTime;

public class Tarefa {
    private int id;
    private String descricao;
    private boolean isConcluida;
    private LocalDateTime dataConclusao;

    public Tarefa(){
        this.dataConclusao = null;
    }
    public int getId(){
        return this.id;
    }
    public LocalDateTime getDataConclusao(){
        return this.dataConclusao;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public boolean isConcluida() {
        return this.isConcluida;
    }
    public void setConcluida(boolean isConcluida) {
        this.isConcluida = isConcluida;
        if(isConcluida){
            dataConclusao =  LocalDateTime.now();
        }else{
            dataConclusao = null;
        }
    }
}
