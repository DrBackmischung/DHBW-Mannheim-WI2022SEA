public class OrderProcessor {
    private InventoryManager inventoryManager;
    private PaymentProcessor paymentProcessor;

    public OrderProcessor(InventoryManager inventoryManager, PaymentProcessor paymentProcessor) {
        this.inventoryManager = inventoryManager;
        this.paymentProcessor = paymentProcessor;
    }

    public void processOrder() throws OrderProcessingException {
        if (!inventoryManager.checkInventory()) {
            throw new OrderProcessingException("Nicht genügend Artikel auf Lager.");
        }

        paymentProcessor.processPayment();
    }
}