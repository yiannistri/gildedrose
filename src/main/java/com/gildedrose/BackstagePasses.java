package com.gildedrose;

public class BackstagePasses extends GildedRoseItem {
    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        ageWell(item);

        item.sellIn = item.sellIn - 1;

        if (hasExpired(item)) {
            item.quality = 0;
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void ageWell(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }
    }
}
