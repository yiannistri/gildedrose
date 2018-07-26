package com.gildedrose;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {
    final Item item;

    AbstractGildedRoseItem(Item item) {
        this.item = item;
    }

    public void setNoQuality() {
        item.quality = 0;
    }

    public void decrementSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    public boolean hasExpired() {
        return expiresBy(0);
    }

    public boolean expiresBy(int expiryTime) {
        return item.sellIn < expiryTime;
    }

    public void decrementQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public void incrementQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

}
