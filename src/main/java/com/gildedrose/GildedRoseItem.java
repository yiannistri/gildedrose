package com.gildedrose;

public class GildedRoseItem {
    final Item item;

    private GildedRoseItem(Item item) {
        this.item = item;
    }

    public static void decrementQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    public static void incrementQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
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
            item.sellIn = item.sellIn - 1;
        }

        if (hasExpired()) {
            if (isAgedBrie()) {
                incrementQuality();
            } else {
                if (isBackstagePasses()) {
                    item.quality = 0;
                } else {
                    if (!isSulfuras()) {
                        decrementQuality();
                    }
                }
            }
        }
    }

    public boolean hasExpired() {
        return expiresBy(0);
    }

    public boolean expiresBy(int expiryTime) {
        return item.sellIn < expiryTime;
    }

    public void decrementQuality() {
        decrementQuality(item);
    }

    public boolean isSulfuras() {
        return isSulfuras(item);
    }

    public boolean isBackstagePasses() {
        return isBackstagePasses(item);
    }

    public void incrementQuality() {
        incrementQuality(item);
    }

    public boolean isAgedBrie() {
        return isAgedBrie(item);
    }
}
