import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TransactionProcess {
    public static void main(String[] args){

         void processTransactions(
        (List<Transaction> transactions, PaymentRouter router) {
            // 1. Supplier: Generate a unique Trace ID for the batch
            Supplier<String> traceIdSupplier = () -> UUID.randomUUID().toString();
            String traceId = traceIdSupplier.get();

            // 2. Predicates: Fraud Detection rules chained with .or()
            Predicate<Transaction> isHighValue = t -> t.getAmount() > 10000.0;
            Predicate<Transaction> isHighRiskMerchant = t -> "GAMBLING".equalsIgnoreCase(t.getMerchantCategory());
            Predicate<Transaction> fraudRule = isHighValue.or(isHighRiskMerchant);

            // 3. Function: Dynamic Fee Calculation
            Function<Transaction, Double> feeCalculator = t -> {
                if (t.isFlagged()) {
                    return 50.00; // Flat investigation fee for flagged transactions
                } else {
                    return t.getAmount() * 0.025; // Standard 2.5% processing fee
                }
            };

            // 4. Consumer: Audit Logging Receipt Generator
            Consumer<Transaction> auditLogger = t -> {
                String network = router.route(t);
                double fee = feeCalculator.apply(t);
                String status = t.isFlagged() ? "FLAGGED (Fraud Check Triggered)" : "APPROVED";

                System.out.println("--------------------------------------------------");
                System.out.println("Audit Receipt:");
                System.out.println("  Trace ID     : " + traceId);
                System.out.println("  Txn ID       : " + t.getTransactionId());
                System.out.println("  Amount/Curr  : " + t.getAmount() + " " + t.getCurrency());
                System.out.println("  Country      : " + t.getOriginCountry());
                System.out.println("  Category     : " + t.getMerchantCategory());
                System.out.println("  Status       : " + status);
                System.out.println("  Calculated Fee: $" + String.format("%.2f", fee));
                System.out.println("  Network Route: " + network);
            };

            System.out.println("=== Starting SecurePay Processing Batch [Trace ID: " + traceId + "] ===");

            // Process each transaction through the functional pipeline
            for (Transaction t : transactions) {
                // Apply fraud rule and update status
                if (fraudRule.test(t)) {
                    t.setFlagged(true);
                }
                // Execute audit consumer
                auditLogger.accept(t);
            }

            System.out.println("--------------------------------------------------");
            System.out.println("=== Batch Processing Complete ===\n");
        }
    }

    // --- Main Execution Class ---
    public class Main {
        public static void main(String[] args) {
            // Initialize a List of 5 varied transactions
            List<Transaction> transactions = Arrays.asList(
                    new Transaction("TXN-101", 150.0, "USD", "US", "RETAIL"),      // Safe Domestic
                    new Transaction("TXN-102", 12500.0, "EUR", "DE", "SOFTWARE"),  // High Value International
                    new Transaction("TXN-103", 500.0, "RWF", "RW", "GAMBLING"),    // High Risk Merchant International
                    new Transaction("TXN-104", 4500.0, "USD", "US", "GAMBLING"),   // High Risk Merchant Domestic
                    new Transaction("TXN-105", 250.0, "GBP", "GB", "RETAIL")       // Safe International
            );

            // Implementing Routing Strategies via Lambdas
            PaymentRouter domesticRouter = t -> "US".equalsIgnoreCase(t.getOriginCountry()) ? "ACH_NETWORK" : null;
            PaymentRouter internationalRouter = t -> !"US".equalsIgnoreCase(t.getOriginCountry()) ? "SWIFT_NETWORK" : null;

            // Combined routing strategy fallback logic
            PaymentRouter productionRouter = t -> {
                String domesticRoute = domesticRouter.route(t);
                if (domesticRoute != null) return domesticRoute;
                return internationalRouter.route(t);
            };

            // Execute the processing pipeline
            TransactionProcessor processor = new TransactionProcessor();
            processor.processTransactions(transactions, productionRouter);
        }
    }
        }
    }
}
