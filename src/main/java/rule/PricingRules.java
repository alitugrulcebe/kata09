package rule;

import item.Item;
import item.ItemBuilder;
import rule.Rule;
import rule.RuleBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class PricingRules {
  HashMap<Item, Rule> map = new HashMap<>();
  HashMap<Item, Integer> items = new HashMap<>();
  private String pricingPath;

  public PricingRules(String path) {
    this.pricingPath = path;
  }

  public void parse() {
    try {
      List<String> allRules = Files.readAllLines(Paths.get(getClass().getClassLoader()
        .getResource(this.pricingPath).toURI()));
      for (String rule : allRules) {
        String[] items = rule.split(",");
        String name = items[0];

        int price = Integer.parseInt(items[1]);
        int discountCount = 0;
        int discountPrice = 0;

        if(items.length > 2) {
          String[] discount = items[2].split("FOR");
          discountCount = Integer.parseInt(discount[0]);
          discountPrice = Integer.parseInt(discount[1]);
        }

        Item item = new ItemBuilder()
          .withName(name)
          .build();

        Rule itemRule = new RuleBuilder()
          .withPrice(price)
          .withDiscountCount(discountCount)
          .withDiscountPrice(discountPrice)
          .build();

        map.put(item, itemRule);
      }
      } catch (IOException e1) {
      e1.printStackTrace();
    } catch (URISyntaxException e) {
      e.printStackTrace();
    }
  }

  public HashMap<Item, Rule> getItemRuleMap() {
    return map;
  }

  public HashMap<Item, Integer> getItems() {
    return items;
  }
}
