package item;

public class ItemBuilder {

  private final Item item;

  public ItemBuilder() {
    this.item = new Item();
  }

  public ItemBuilder withName(String name) {
    item.setName(name);
    return this;
  }
  public Item build() {
    return item;
  }
}
