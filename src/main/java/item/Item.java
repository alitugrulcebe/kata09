package item;

import rule.Rule;

public class Item {
  String name;

  public Item() {
  }

  public Item(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int applyRule(Rule rule, int count) {
    int discountCount = rule.getDiscountCount();
    int discountPrice = rule.getDiscountPrice();
    int regularPrice = rule.getPrice();

    if (discountCount > 0 && count >= discountCount) {
      int discountedItems = count/discountCount;
      int regularPricedItems = count - (discountedItems * discountCount);

      return discountedItems * discountPrice + regularPricedItems * regularPrice;
    } else {
      return count * regularPrice;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Item item = (Item) o;

    if (name != null ? !name.equals(item.name) : item.name != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  @Override
  public String toString() {
    return "Item{" +
      "name='" + name + '\'' +
      '}';

  }
}
