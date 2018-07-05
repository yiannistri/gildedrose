package com.gildedrose;

public class AgedBrie extends GildedRoseItem {
    private final Item item;

    public AgedBrie(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        ageWell(item);

        item.sellIn = item.sellIn - 1;

        if (hasExpired(item)) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void ageWell(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}
