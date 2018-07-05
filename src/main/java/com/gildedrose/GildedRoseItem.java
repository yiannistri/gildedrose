package com.gildedrose;

public abstract class GildedRoseItem {
    abstract void updateQuality();

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
        return new OtherItem(item);
    }
}
