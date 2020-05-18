package cn.xpbootcamp.gilded_rose;

class GildedRose {
    CommodityItem[] commodityItems;

    public GildedRose(CommodityItem[] commodityItems) {
        this.commodityItems = commodityItems;
    }

    public void updateQuality() {
        for (CommodityItem item : commodityItems) {
            item.updateCommodityItemQuality();
        }
    }
}
