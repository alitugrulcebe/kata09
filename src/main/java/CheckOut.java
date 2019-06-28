import item.Item;
import rule.PricingRules;

public class CheckOut {
  InventoryManager inventoryManager;
  public CheckOut(PricingRules rules) {
    inventoryManager = new InventoryManager(rules);
    inventoryManager.parseRules();
  }

  public void scan(Item item) {
    inventoryManager.scan(item);
  }

  public int total() {
    return inventoryManager.total();
  }
}
