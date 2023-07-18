package enumeracoes_composicao.enums1.application;

import enumeracoes_composicao.enums1.model.entities.Client;
import enumeracoes_composicao.enums1.model.entities.Order;
import enumeracoes_composicao.enums1.model.entities.OrderItem;
import enumeracoes_composicao.enums1.model.entities.Product;
import enumeracoes_composicao.enums1.model.enums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");


        System.out.println("Enter client data:");
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Email: ");
        String email = in.next();
        System.out.print("Birth date(DD/MM/YYYY): ");
        LocalDate birthDate = LocalDate.parse(in.next(), dtf);
        Client client = new Client(name, email,birthDate);

        System.out.println("Enter order data:");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(in.next());
        Order order = new Order(LocalDateTime.now(), status, client);

        System.out.print("How many items to this order? ");
        int n = in.nextInt();

        for (int i = 1; i <= n; i++){
            System.out.println("Enter #" + i + " item data:");
            System.out.print("Product name: ");
            in.nextLine();
            String productName = in.nextLine();
            System.out.print("Product price: ");
            double price = in.nextDouble();
            System.out.print("Quantity: ");
            int quantity = in.nextInt();

            Product product = new Product(productName, price);
            OrderItem item = new OrderItem(quantity, price, product);
            order.addItem(item);
        }
        System.out.println();
        System.out.println(order);

        in.close();
    }
}
