public class Transaction {

        private String transactionId;
        private double amount;
        private String currency;
        private String originCountry;
        private String merchantCategory;
        private boolean isFlagged;

        public Transaction(String transactionId, double amount, String currency, String originCountry, String merchantCategory) {
            this.transactionId = transactionId;
            this.amount = amount;
            this.currency = currency;
            this.originCountry = originCountry;
            this.merchantCategory = merchantCategory;
            this.isFlagged = false; // default
        }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getMerchantCategory() {
        return merchantCategory;
    }

    public void setMerchantCategory(String merchantCategory) {
        this.merchantCategory = merchantCategory;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    @Override
        public String toString() {
            return String.format("Transaction{id='%s', amount=%.2f %s, country='%s', category='%s', flagged=%b}",
                    transactionId, amount, currency, originCountry, merchantCategory, isFlagged);
        }
    }

