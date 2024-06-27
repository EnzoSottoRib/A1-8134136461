public class App {
    public static void main(String[] args) throws Exception {
        Controle controle = new Controle();
        System.out.println(controle.listarAlunos());
        System.out.println("Total de alunos: " + controle.getTotal());
        System.out.println("Total de aprovados: " + controle.getAprovados());
        System.out.println("Total de reprovados: " + controle.getReprovados());
        System.out.println("Menor nota da turma: " + controle.getMenorNota());
        System.out.println("Maior nota da turma: " + controle.getMaiorNota());
        System.out.println("Média geral: " + controle.getMediaGeralFormatada());

        controle.escreverResumoCSV("resumo.csv");
    }
}
