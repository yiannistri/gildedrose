package com.gildedrose;

public interface GildedRoseItem {
    static GildedRoseItem gildedRoseItem(Item item) {
        if (isAgedBrie(item)) {
            return new AgedBrie(item);
        }
        if (isBackstagePasses(item)) {
            return new BackstagePasses(item);
        }
        if (isSulfuras(item)) {
            return new Sulfuras();
        }
        return new Normal(item);
    }

    static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    static boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    void updateQuality();
}
