package com.gildedrose;

public class ConjuredItem extends NormalItem {
    public ConjuredItem(Item item) {
        super(item);
    }

    @Override
    void decreaseQuality(Item item) {
        super.decreaseQuality(item);
        super.decreaseQuality(item);
    }
}
