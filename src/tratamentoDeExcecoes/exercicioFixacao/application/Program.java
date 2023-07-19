package tratamentoDeExcecoes.exercicioFixacao.application;

import tratamentoDeExcecoes.exercicioFixacao.model.entities.Account;
import tratamentoDeExcecoes.exercicioFixacao.model.exceptions.BusinessException;

import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        Account account;

        try {
            System.out.println("Enter account data");
            System.out.print("Number: ");
            int number = in.nextInt();
            System.out.print("Holder: ");
            in.nextLine();
            String holder = in.nextLine();
            System.out.print("Initial balance: ");
            double inititalBalance = in.nextDouble();
            System.out.print("Withdraw limit: ");
            double withdrawLimit = in.nextDouble();

            account = new Account(number, holder, inititalBalance, withdrawLimit);

            System.out.print("Enter amount for withdraw: ");
            double amount = in.nextDouble();
            account.withdraw(amount);
            System.out.printf("New balance: %.2f\n", account.getBalance());
        }
        catch (BusinessException e){
            System.out.println(e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }

        in.close();
    }
}
