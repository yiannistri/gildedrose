package com.gildedrose;

public interface GildedRoseItem {
    static GildedRoseItem gildedRoseItem(Item item) {
        if (item.name.equals(GildedRose.AGED_BRIE)) {
            return new AgedBrie(item);
        }
        if (item.name.equals(GildedRose.BACKSTAGE_PASSES)) {
            return new BackstagePasses(item);
        }
        if (item.name.equals(GildedRose.SULFURAS)) {
            return new Sulfuras();
        }
        if (item.name.equals(GildedRose.CONJURED)) {
            return new ConjuredItem(item);
        }
        return new NormalItem(item);
    }

    void updateQuality();
}
