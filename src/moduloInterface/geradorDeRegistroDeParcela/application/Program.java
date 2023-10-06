package moduloInterface.geradorDeRegistroDeParcela.application;

import moduloInterface.geradorDeRegistroDeParcela.model.entites.Contract;
import moduloInterface.geradorDeRegistroDeParcela.model.entites.Installment;
import moduloInterface.geradorDeRegistroDeParcela.model.service.ContractService;
import moduloInterface.geradorDeRegistroDeParcela.model.service.PaypalService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato");
        System.out.print("Numero: ");
        int contractNumber = in.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(in.next(),fmt);
        System.out.print("Valor do contrato: ");
        double totalValue = in.nextDouble();

        Contract contract = new Contract(contractNumber, date,totalValue);

        System.out.print("Entre com o numero de parcelas: ");
        int parcelas = in.nextInt();

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, parcelas);

        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }
    }
}
