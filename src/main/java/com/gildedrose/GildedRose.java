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
    
    private void processItem(Item item) {
        checkQuality(item);
        checkSellByDate(item);
    }

    private void checkQuality(Item item) {
        if (item.name.equals("Aged Brie") || isBackStagePass(item)) {
               updateItemQuality(item, 1 );
        } else if (item.quality > 0) {
            updateItemQuality(item, -1);
        }
    }

    private boolean isBackStagePass(Item item) {
        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                updateItemQuality(item,  1);
            }

            if (item.sellIn < 6) {
                updateItemQuality(item,  1);
            }
            return true;
        } else return false;
    }

    private void updateItemQuality(Item item, int i) {
        if (i < 0 && !isLegendary(item)) {
                item.quality = item.quality + i;
        }
        if (item.quality < 50) {
            if (item.name.startsWith("Conjured") && i < 0){
                item.quality = item.quality + 2*i;
            }
            item.quality = item.quality + i;
        }
    }
    
    private boolean isLegendary(Item item){
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void checkSellByDate(Item item) {
        if (!isLegendary(item)) {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                updateItemQuality(item, 1);
            } else {
                if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.quality > 0) {
                        updateItemQuality(item, -1);
                    }
                } else item.quality = 0;
            }
        }
    }


}