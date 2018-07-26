package com.gildedrose;

public class GildedRoseItem {
    private final Item item;

    private GildedRoseItem(Item item) {
        this.item = item;
    }

    public static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    public static boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    public static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    public static GildedRoseItem gildedRoseItem(Item item) {
        return new GildedRoseItem(item);
    }

    public void updateQuality() {
        if (isAgedBrie() || isBackstagePasses()) {
            incrementQuality();
            if (isBackstagePasses()) {
                if (expiresBy(11)) {
                    incrementQuality();
                }

                if (expiresBy(6)) {
                    incrementQuality();
                }
            }
        } else {
            if (!isSulfuras()) {
                decrementQuality();
            }
        }

        if (!isSulfuras()) {
            decrementSellIn();
        }

        if (hasExpired()) {
            if (isAgedBrie()) {
                incrementQuality();
            } else {
                if (isBackstagePasses()) {
                    setNoQuality();
                } else {
                    if (!isSulfuras()) {
                        decrementQuality();
                    }
                }
            }
        }
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

    public boolean isSulfuras() {
        return isSulfuras(item);
    }

    public boolean isBackstagePasses() {
        return isBackstagePasses(item);
    }

    public boolean isAgedBrie() {
        return isAgedBrie(item);
    }
}
