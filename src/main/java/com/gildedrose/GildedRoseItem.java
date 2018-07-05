package com.gildedrose;

public interface GildedRoseItem {
    void updateQuality();

    static GildedRoseItem gildedRoseItem(Item item) {
        if (item.name.equals(GildedRose.AGED_BRIE)) {
            return new AgedBrie(item);
        }
        if (item.name.equals(GildedRose.BACKSTAGE_PASSES)) {
            return new BackstagePasses(item);
        }
        if (item.name.equals(GildedRose.SULFURAS)) {
            return new Sulfuras(item);
        }
        return new OtherItem(item);
    }
}
