import item.Item;
import rule.PricingRules;
import rule.Rule;

import java.util.HashMap;

public class InventoryManager {
  private static InventoryManager inventoryManager;
  private PricingRules rules;
  private HashMap<Item,Integer> items = new HashMap<>();

  public InventoryManager(PricingRules rules) {
    this.rules = rules;
  }

  public void scan(Item item) {
    if(!items.containsKey(item)) {
        items.put(item,1);
    } else {
        items.put(item,items.getOrDefault(item,0) + 1);
    }
  }

  public int total() {
      int total = 0;
      for(Item item: items.keySet()) {
        Rule rule = rules.getItemRuleMap().get(item);
        if(rule == null)
          throw new IllegalArgumentException("Unknown item: " + item);
        int count = items.get(item) == null? 0 :items.get(item);
        total += item.applyRule(rule,count);
      }
      return total;
  }

  public void parseRules() {
    rules.parse();
  }
}
