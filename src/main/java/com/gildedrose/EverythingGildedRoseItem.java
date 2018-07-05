package com.gildedrose;

import static com.gildedrose.GildedRose.*;

public abstract class EverythingGildedRoseItem implements GildedRoseItem {
    public final Item item;

    public EverythingGildedRoseItem(Item item) {
        this.item = item;
    }

    @Override
    public void updateQuality() {
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

    private void ageBadly(Item item) {
        if (item.quality > 0) {
            if (!isSulfuras(item)) {
                item.quality = item.quality - 1;
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

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS);
    }
}
