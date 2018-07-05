package com.gildedrose;

import static com.gildedrose.GildedRoseItem.gildedRoseItem;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            gildedRoseItem(item).updateQuality();
        }
    }
}