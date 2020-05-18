package cn.xpbootcamp.gilded_rose;

class GildedRose {
    CommodityItem[] commodityItems;

    public GildedRose(CommodityItem[] commodityItems) {
        this.commodityItems = commodityItems;
    }

    public void update_quality() {
        for (int i = 0; i < commodityItems.length; i++) {
            if (!commodityItems[i].commodityName.equals("Aged Brie")
                    && !commodityItems[i].commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (commodityItems[i].quality > 0) {
                    if (!commodityItems[i].commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                        commodityItems[i].quality = commodityItems[i].quality - 1;
                    }
                }
            } else {
                if (commodityItems[i].quality < 50) {
                    commodityItems[i].quality = commodityItems[i].quality + 1;

                    if (commodityItems[i].commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (commodityItems[i].sellIn < 11) {
                            if (commodityItems[i].quality < 50) {
                                commodityItems[i].quality = commodityItems[i].quality + 1;
                            }
                        }

                        if (commodityItems[i].sellIn < 6) {
                            if (commodityItems[i].quality < 50) {
                                commodityItems[i].quality = commodityItems[i].quality + 1;
                            }
                        }
                    }
                }
            }

            if (!commodityItems[i].commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                commodityItems[i].sellIn = commodityItems[i].sellIn - 1;
            }

            if (commodityItems[i].sellIn < 0) {
                if (!commodityItems[i].commodityName.equals("Aged Brie")) {
                    if (!commodityItems[i].commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (commodityItems[i].quality > 0) {
                            if (!commodityItems[i].commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                                commodityItems[i].quality = commodityItems[i].quality - 1;
                            }
                        }
                    } else {
                        commodityItems[i].quality = 0;
                    }
                } else {
                    if (commodityItems[i].quality < 50) {
                        commodityItems[i].quality = commodityItems[i].quality + 1;
                    }
                }
            }
        }
    }
}
