package tree;

import catcafe.CatCafe;
import catcafe.FelineOverLord;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CatCafeTest {

    @Test
    void newCafeShouldBeEmpty() {

        CatCafe cafe = new CatCafe();

        assertEquals(0, cafe.getCatCount(), "Ein neues Café sollte 0 Katzen haben.");
    }

    @Test
    void addingOneCatShouldIncreaseCount() {

        CatCafe cafe = new CatCafe();
        FelineOverLord minka = new FelineOverLord("Minka", 3);

        cafe.addCat(minka);

        assertEquals(1, cafe.getCatCount());
    }

    @Test
    void addingMultipleCatsShouldWork() {

        CatCafe cafe = new CatCafe();

        cafe.addCat(new FelineOverLord("Cat1", 2));
        cafe.addCat(new FelineOverLord("Cat2", 4));
        cafe.addCat(new FelineOverLord("Cat3", 5));

        assertEquals(3, cafe.getCatCount());
    }

    @Test
    void shouldFindCatByName() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Morticia", 3));

        FelineOverLord found = cafe.getCatByName("Morticia");

        assertNotNull(found);
        assertEquals("Morticia", found.name());
    }

    @Test
    void searchingNonExistentNameShouldReturnNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Sooky", 2));

        FelineOverLord result = cafe.getCatByName("Garfield");

        assertNull(result, "Nicht existierende Katze sollte null zurückgeben.");
    }

    @Test
    void searchingForNullNameShouldReturnNull() {

        CatCafe cafe = new CatCafe();

        FelineOverLord result = cafe.getCatByName(null);

        assertNull(result);
    }

    @Test
    void shouldFindCatInWeightRange() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Chonk", 8));

        FelineOverLord result = cafe.getCatByWeight(5, 10);

        assertNotNull(result);
        assertEquals(8, result.weight());
    }

    @Test
    void shouldReturnNullIfNoCatInWeightRange() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Kitty", 2));

        FelineOverLord result = cafe.getCatByWeight(5, 10);

        assertNull(result);
    }

    @Test
    void invalidWeightRangeShouldReturnNull() {

        CatCafe cafe = new CatCafe();
        cafe.addCat(new FelineOverLord("Kitty", 4));

        FelineOverLord result = cafe.getCatByWeight(10, 5);

        assertNull(result, "Wenn min > max, sollte null zurückkommen.");
    }

    @Test
    void negativeWeightShouldReturnNull() {

        CatCafe cafe = new CatCafe();

        FelineOverLord result = cafe.getCatByWeight(-1, 5);

        assertNull(result, "Negatives Gewicht darf nicht erlaubt sein.");
    }
}
