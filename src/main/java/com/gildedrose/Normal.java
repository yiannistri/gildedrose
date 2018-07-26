package com.gildedrose;

class Normal extends AbstractGildedRoseItem {
    public Normal(Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decrementQuality();

        decrementSellIn();

        if (hasExpired()) {
            decrementQuality();
        }
    }
}
