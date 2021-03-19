package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(this::processItem);
    }

    private void updateItemQuality(Item item, boolean b, int i) {
        if (b) {
            item.quality = i;
        }
    }

    private void processItem(Item item) {
        if (item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;

                        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                            if (item.sellIn < 11) {
                                updateItemQuality(item, item.quality < 50, item.quality + 1);
                            }

                            if (item.sellIn < 6) {
                                updateItemQuality(item, item.quality < 50, item.quality + 1);
                            }
                        }
                    }
                } else {
            if (item.quality > 0) {
                updateItemQuality(item, !item.name.equals("Sulfuras, Hand of Ragnaros"), item.quality - 1);
            }
        }
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                updateItemQuality(item, item.quality < 50, item.quality + 1);
            } else {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        updateItemQuality(item, !item.name.equals("Sulfuras, Hand of Ragnaros"), item.quality - 1);
                    }
                } else item.quality = 0;
            }
        }
    }
}