package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {
    private final Item item;

    AbstractGildedRoseItem(Item item) {
        this.item = item;
    }

    void setNoQuality() {
        item.quality = 0;
    }

    void decrementSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    boolean hasExpired() {
        return expiresBy(0);
    }

    boolean expiresBy(int expiryTime) {
        return item.sellIn < expiryTime;
    }

    void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    void incrementQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
