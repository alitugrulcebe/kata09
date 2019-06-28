package rule;

public class Rule {
  private int price;
  private int discountCount;
  private int discountPrice;

  public int getPrice() {
    return price;
  }

  public int getDiscountCount() {
    return discountCount;
  }

  public int getDiscountPrice() {
    return discountPrice;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public void setDiscountCount(int discountCount) {
    this.discountCount = discountCount;
  }

  public void setDiscountPrice(int discountPrice) {
    this.discountPrice = discountPrice;
  }
}
