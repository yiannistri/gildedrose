package com.gildedrose;

public interface GildedRoseItem {
    void updateQuality();

    static GildedRoseItem gildedRoseItem(Item item) {
        return new EverythingGildedRoseItem(item);
    }
}
