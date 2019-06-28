package rule;

public class RuleBuilder {
  private final Rule rule;

  public RuleBuilder() {
    this.rule = new Rule();
  }

  public RuleBuilder withPrice(int price) {
    rule.setPrice(price);
    return this;
  }

  public RuleBuilder withDiscountPrice(int discountPrice) {
    rule.setDiscountPrice(discountPrice);
    return this;
  }

  public RuleBuilder withDiscountCount(int count) {
    rule.setDiscountCount(count);
    return this;
  }

  public Rule build() {
    return rule;
  }

}
