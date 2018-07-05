package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {
    boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }
}
