public class Payment {

    @FunctionalInterface
    public interface PaymentRouter {
        String route(Transaction t);
    }
}
