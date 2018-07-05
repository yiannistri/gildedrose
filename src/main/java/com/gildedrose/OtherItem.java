package com.gildedrose;

public class OtherItem extends AbstractGildedRoseItem {
    private final Item item;

    public OtherItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
        ageBadly(item);

        item.sellIn = item.sellIn - 1;

        if (hasExpired(item)) {
            ageBadly(item);
        }
    }

    private void ageBadly(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }
}
