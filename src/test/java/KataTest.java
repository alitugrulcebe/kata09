import item.Item;
import item.ItemBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rule.PricingRules;

import static org.junit.Assert.assertEquals;

public class KataTest {

  PricingRules rules;

  @Before
  public void setUp() throws Exception {
    rules = new PricingRules("pricing.txt");
  }

  @After
  public void tearDown() throws Exception {
    this.rules = null;
  }

  @Test
  public void testTotal() throws Exception {
    assertEquals(0, price(""));
    assertEquals(50, price("A"));
    assertEquals(80, price("AB"));
    assertEquals(115, price("CDBA"));

    assertEquals(100, price("AA"));
    assertEquals(130, price("AAA"));
    assertEquals(180, price("AAAA"));
    assertEquals(230, price("AAAAA"));
    assertEquals(260, price("AAAAAA"));

    assertEquals(160, price("AAAB"));
    assertEquals(175, price("AAABB"));
    assertEquals(190, price("AAABBD"));
    assertEquals(190, price("DABABA"));
  }

  @Test
  public void testIncremental() throws Exception {
    CheckOut checkOut = new CheckOut(rules);

    assertEquals(0, checkOut.total());
    checkOut.scan(new Item("A"));
    assertEquals(50, checkOut.total());
    checkOut.scan(new Item("B"));
    assertEquals(80, checkOut.total());
    checkOut.scan(new Item("A"));
    assertEquals(130, checkOut.total());
    checkOut.scan(new Item("A"));
    assertEquals(160, checkOut.total());
    checkOut.scan(new Item("B"));
    assertEquals(175, checkOut.total());
  }

  public int price(String itemNames) throws Exception {
    CheckOut checkOut = new CheckOut(rules);
    for (int i = 0; i < itemNames.length(); i++) {
      String name = Character.toString(itemNames.charAt(i));
      Item item = new ItemBuilder().withName(name).build();
      checkOut.scan(item);
    }
    return checkOut.total();
  }
}

