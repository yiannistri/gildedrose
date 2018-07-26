package com.gildedrose;

class AgedBrie extends AbstractGildedRoseItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        decrementSellIn();

        if (hasExpired()) {
            incrementQuality();
        }
    }
}
