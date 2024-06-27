import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class Controle {
    private GerencioadorDeArquivosAlunos leitorA;

    ArrayList<Aluno> listaAlunosCon = new ArrayList<>();

    private int aprovados;
    private int total;
    private int reprovados;
    private double menorNota = 10;
    private double maiorNota = 0;
    private double mediaGeral;

    public Controle(){
        this.leitorA = new GerencioadorDeArquivosAlunos();
        this.listaAlunosCon = leitorA.getAlunos();
        this.aprovados = 0;
        this.total = 0;
        this.reprovados = 0;
        this.mediaGeral = 0;
    }

    public String listarAlunos(){
        StringBuilder sb = new StringBuilder();
        if (listaAlunosCon == null){
            return "lista vazia!";
        } else {
            for(Aluno aluno : listaAlunosCon){
                sb.append(aluno.toString()).append("\n");
                total++;
                mediaGeral += aluno.getNota();
                if(aluno.getNota()>=6){
                    aprovados++;
                } else {
                    reprovados++;
                }
                if(aluno.getNota()>maiorNota){
                    maiorNota = aluno.getNota();
                }
                if(aluno.getNota()<menorNota){
                    menorNota = aluno.getNota();
                }
            }

        } return sb.toString();
    }

    public int getAprovados(){
        return aprovados;
    }

    public int getReprovados(){
        return reprovados;
    }

    public int getTotal(){
        return total;
    }

    public String getMediaGeral(){
        DecimalFormat df = new DecimalFormat("#.#");
        return df.format(mediaGeral / total);
    }

    public double getMaiorNota(){
        return maiorNota;
    }

    public double getMenorNota(){
        return menorNota;
    }

    public void escreverResumoCSV(String arquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(arquivo))) {
            writer.println("Quantidade de alunos: " + getTotal());
            writer.println("Quantidade de aprovados: " + getAprovados());
            writer.println("Quantidade de reprovados: " + getReprovados());
            writer.println("Menor nota da turma: " + getMenorNota());
            writer.println("Maior nota da turma: " + getMaiorNota());
            writer.println("Média geral: " + getMediaGeralFormatada());
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public String getMediaGeralFormatada() {
        double media = mediaGeral / total;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setDecimalSeparator('.');
        DecimalFormat df = new DecimalFormat("#.##", symbols);

        return df.format(media);
    }

}
