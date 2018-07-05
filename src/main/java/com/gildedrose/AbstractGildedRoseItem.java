package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {
    boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
