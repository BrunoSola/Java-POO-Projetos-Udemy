package moduloInterface.geradorDeRegistroDeParcela.model.service;

public class PaypalService implements OnlinePaymentService{

    @Override
    public double paymentFee(Double amount) {
        return 0;
    }

    @Override
    public double interest(Double amount, Integer months) {
        return 0;
    }
}
