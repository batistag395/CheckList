import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CheckList {
    public List<Tarefa> todasAsTarefas;
    public CheckList(){
        this.todasAsTarefas = new ArrayList<>();
    }

    public void addTarefa(Tarefa tarefa){
        todasAsTarefas.add(tarefa);
    }
    public List<Tarefa> getTodasAsTarefas(){
        return todasAsTarefas;
    }
    public List<Tarefa> getTodasAsTarefasConcluidas(){
        List<Tarefa> todasAsTarefasConcluidas = todasAsTarefas.stream().filter(tarefa -> tarefa.isConcluida()).toList();
        return todasAsTarefasConcluidas;
    }
    public List<Tarefa> getTodasAsTarefasPendentes(){
        List<Tarefa> todasAsTarefasConcluidas = todasAsTarefas.stream().filter(tarefa -> !tarefa.isConcluida()).toList();
        return todasAsTarefasConcluidas;
    }
    public void alterarStatusTarefa(int id, boolean status){
        todasAsTarefas.stream()
                .filter(tarefa -> tarefa.getId() == id)
                .map(tarefa -> {
                    tarefa.setConcluida(status);
                    return tarefa;
                }).collect(Collectors.toList());
    }
    public List<String> getTodasAsDescricoes(){
        List<String> todasAsDescricoes = todasAsTarefas.stream().map(Tarefa::getDescricao).collect(Collectors.toList());
        return todasAsDescricoes;
    }
    public List<Tarefa> getTodasAsTarefasOrdenadasPorConclusao() {
        return todasAsTarefas.stream()
                .sorted(
                        Comparator.comparing(Tarefa::getDataConclusao, Comparator.nullsLast(Comparator.reverseOrder()))
                        .thenComparing(Tarefa::getDescricao))
                .collect(Collectors.toList());
    }
}