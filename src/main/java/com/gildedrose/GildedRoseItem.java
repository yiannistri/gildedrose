package com.gildedrose;

public abstract class GildedRoseItem {
    private final Item item;

    private GildedRoseItem(Item item) {
        this.item = item;
    }

    public static GildedRoseItem gildedRoseItem(Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrie(item);
        }
        if (isBackstagePasses(item)) {
            return new BackstagePasses(item);
        }
        if (isSulfuras(item)) {
            return new Sulfuras(item);
        }
        return new Normal(item);
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

    private static class AgedBrie extends GildedRoseItem {
        public AgedBrie(Item item) {
            super(item);
        }
    }

    private static class BackstagePasses extends GildedRoseItem {
        public BackstagePasses(Item item) {
            super(item);
        }
    }

    private static class Sulfuras extends GildedRoseItem {
        public Sulfuras(Item item) {
            super(item);
        }
    }

    private static class Normal extends GildedRoseItem {
        public Normal(Item item) {
            super(item);
        }
    }
}
