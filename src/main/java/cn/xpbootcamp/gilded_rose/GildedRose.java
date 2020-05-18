package cn.xpbootcamp.gilded_rose;

class GildedRose {
    CommodityItem[] commodityItems;

    public GildedRose(CommodityItem[] commodityItems) {
        this.commodityItems = commodityItems;
    }

    public void update_quality() {
        for (int i = 0; i < commodityItems.length; i++) {
            CommodityItem item = commodityItems[i];
            item.updateCommodityItemQuality();
        }
    }
}
