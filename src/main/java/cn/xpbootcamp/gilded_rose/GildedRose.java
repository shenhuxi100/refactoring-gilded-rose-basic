package cn.xpbootcamp.gilded_rose;

class GildedRose {
    CommodityItem[] commodityItems;

    public GildedRose(CommodityItem[] commodityItems) {
        this.commodityItems = commodityItems;
    }

    public void update_quality() {
        for (int i = 0; i < commodityItems.length; i++) {
            if (commodityItems[i].commodityName.equals("Aged Brie")
                    || commodityItems[i].commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                handleQualityLessThan50(i);
            } else {
                commodityItemQualityMinusOne(i);
            }

            if (!commodityItems[i].commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                commodityItems[i].sellIn = commodityItems[i].sellIn - 1;
            }

            handleSellInLessThanZero(i);
        }
    }

    private void handleQualityLessThan50(int i) {
        if (commodityItems[i].quality < 50) {
            commodityItems[i].quality = commodityItems[i].quality + 1;

            if (commodityItems[i].commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (commodityItems[i].sellIn < 11) {
                    commodityItemQualityPlusOne(i);
                }

                if (commodityItems[i].sellIn < 6) {
                    commodityItemQualityPlusOne(i);
                }
            }
        }
    }

    private void handleSellInLessThanZero(int i) {
        if (commodityItems[i].sellIn < 0) {
            if (commodityItems[i].commodityName.equals("Aged Brie")) {
                commodityItemQualityPlusOne(i);
            } else {
                if (commodityItems[i].commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    commodityItems[i].quality = 0;
                } else {
                    commodityItemQualityMinusOne(i);
                }
            }
        }
    }

    private void commodityItemQualityPlusOne(int i) {
        if (commodityItems[i].quality < 50) {
            commodityItems[i].quality = commodityItems[i].quality + 1;
        }
    }

    private void commodityItemQualityMinusOne(int i) {
        if (commodityItems[i].quality > 0 && !commodityItems[i].commodityName.equals("Sulfuras, Hand of Ragnaros")) {
            commodityItems[i].quality = commodityItems[i].quality - 1;
        }
    }
}
