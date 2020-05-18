package cn.xpbootcamp.gilded_rose;

class GildedRose {
    CommodityItem[] commodityItems;

    public GildedRose(CommodityItem[] commodityItems) {
        this.commodityItems = commodityItems;
    }

    public void update_quality() {
        for (int i = 0; i < commodityItems.length; i++) {
            CommodityItem item = commodityItems[i];
            if (item.commodityName.equals("Aged Brie")
                    || item.commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                handleQualityLessThan50(item);
            } else {
                commodityItemQualityMinusOne(item);
            }

            if (!item.commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            handleSellInLessThanZero(item);
        }
    }

    private void handleQualityLessThan50(CommodityItem item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11) {
                    commodityItemQualityPlusOne(item);
                }

                if (item.sellIn < 6) {
                    commodityItemQualityPlusOne(item);
                }
            }
        }
    }

    private void handleSellInLessThanZero(CommodityItem item) {
        if (item.sellIn < 0) {
            if (item.commodityName.equals("Aged Brie")) {
                commodityItemQualityPlusOne(item);
            } else {
                if (item.commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = 0;
                } else {
                    commodityItemQualityMinusOne(item);
                }
            }
        }
    }

    private void commodityItemQualityPlusOne(CommodityItem item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void commodityItemQualityMinusOne(CommodityItem item) {
        if (item.quality > 0 && !item.commodityName.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }
}
