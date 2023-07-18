package heranca_polimorfismo.calculoSimplesImposto.application;

import heranca_polimorfismo.calculoSimplesImposto.model.entities.Contribuinte;
import heranca_polimorfismo.calculoSimplesImposto.model.entities.PessoaFisica;
import heranca_polimorfismo.calculoSimplesImposto.model.entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        List<Contribuinte> contribuintes = new ArrayList<>();

        System.out.print("Entre com a quantidade de contribuintes: ");
        int n = in.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Dados do Contribuinte #" + i + ":");
            System.out.print("Pessoa Fisica ou Jurídica(f/j)? ");
            char ch = in.next().toLowerCase().charAt(0);
            System.out.print("Nome: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Renda Anual: R$");
            double rendaAnual = in.nextDouble();
            if (ch == 'f'){
                System.out.print("Gastos com saúde: R$");
                double gastoSaude = in.nextDouble();
                contribuintes.add(new PessoaFisica(name, rendaAnual, gastoSaude));
            } else if (ch == 'j') {
                System.out.print("Quantidade de funcionarios: ");
                int qtdFuncionarios = in.nextInt();
                contribuintes.add(new PessoaJuridica(name, rendaAnual, qtdFuncionarios));
            }
        }
        System.out.println("\nImposto a Pagar");
        double sum = 0.0;
        for (Contribuinte contribuinte : contribuintes){
            System.out.println(contribuinte.getName() + ": R$" + String.format("%.2f", contribuinte.tax()));
            sum += contribuinte.tax();
        }
        System.out.print("\nTotal de Imposto: R$" + String.format("%.2f", sum));

        in.close();
    }
}
