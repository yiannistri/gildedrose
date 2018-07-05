package com.gildedrose;

public class OtherItem extends AbstractGildedRoseItem {
    private final Item item;

    public OtherItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }

        item.sellIn = item.sellIn - 1;

        if (hasExpired(item)) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }
}
