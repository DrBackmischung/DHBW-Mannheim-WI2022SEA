import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class OrderProcessorIntegrationTest {

    @Test
    public void testOrderProcessingIntegration() {
        InventoryManager inventoryManager = new InventoryManager();
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        OrderProcessor orderProcessor = new OrderProcessor(inventoryManager, paymentProcessor);

        try {
            orderProcessor.processOrder();

            inventoryManager = new InventoryManager() {
                @Override
                public boolean checkInventory() {
                    return false; 
                }
            };

            orderProcessor = new OrderProcessor(inventoryManager, paymentProcessor);

            orderProcessor.processOrder();
            fail("Erwartete OrderProcessingException wurde nicht ausgelöst.");

        } catch (OrderProcessingException e) {
            assertTrue(e.getMessage().contains("Nicht genügend Artikel auf Lager."));

        } catch (Exception e) {
            fail("Unerwartete Exception: " + e.getMessage());
        }
    }
}
