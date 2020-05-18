package cn.xpbootcamp.gilded_rose;

public class CommodityItem {

    public String commodityName;

    public int sellIn;

    public int quality;

    public CommodityItem(String commodityName, int sellIn, int quality) {
        this.commodityName = commodityName;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.commodityName + ", " + this.sellIn + ", " + this.quality;
    }
}
