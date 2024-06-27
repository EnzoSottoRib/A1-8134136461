import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GerencioadorDeArquivosAlunos {

    public String header = "Matrícula; Nome; Nota";
    public String nomeDoArquivo;

    public GerencioadorDeArquivosAlunos(){
        nomeDoArquivo = "C:\\Users\\autologon\\Documents\\A1-8134136461\\Projeto\\src\\alunos.csv";
    }

    public ArrayList<Aluno> getAlunos(){
        ArrayList<Aluno> listaAlunos = new ArrayList<>();

        try {
            File arquivo = new File(nomeDoArquivo);
            Scanner leitor = new Scanner(arquivo);

            header = leitor.nextLine();

            while (leitor.hasNextLine()){
                String linhaAtual = leitor.nextLine();
                String dados[] = linhaAtual.split(";"); 

                int matricula = Integer.parseInt(dados[0].trim());
                String nome = dados[1];
                Double nota = Double.parseDouble(dados[2].trim().replace(",", "."));

                Aluno alunoObj = new Aluno(matricula, nome, nota);
                listaAlunos.add(alunoObj);
            } leitor.close();

        } catch (FileNotFoundException e){
            System.out.println("Arquivo 'alunos.csv' não foi encontrado!");
        }
        return listaAlunos;
    }
}
