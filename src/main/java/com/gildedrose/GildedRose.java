package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (getsBetterWithAge(item)) {
                ageWell(item);
            } else {
                ageBadly(item);
            }

            if (!isSulfuras(item)) {
                item.sellIn = item.sellIn - 1;
            }

            if (hasExpired(item)) {
                if (isBrie(item)) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                } else {
                    if (isBackstagePasses(item)) {
                        item.quality = 0;
                    } else {
                        ageBadly(item);
                    }
                }
            }
        }
    }

    private boolean hasExpired(Item item) {
        return item.sellIn < 0;
    }

    private void ageWell(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (isBackstagePasses(item)) {
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

    private boolean getsBetterWithAge(Item item) {
        return isBrie(item) || isBackstagePasses(item);
    }

    private boolean isBackstagePasses(Item item) {
        return item.name.equals(BACKSTAGE_PASSES);
    }

    private boolean isBrie(Item item) {
        return item.name.equals(AGED_BRIE);
    }

    private void ageBadly(Item item) {
        if (item.quality > 0) {
            if (!isSulfuras(item)) {
                item.quality = item.quality - 1;
            }
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }
}