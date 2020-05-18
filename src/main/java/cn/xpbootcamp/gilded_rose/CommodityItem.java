package cn.xpbootcamp.gilded_rose;

public class CommodityItem {

    private String commodityName;
    private int sellIn;
    private int quality;

    public CommodityItem(String commodityName, int sellIn, int quality) {
        this.commodityName = commodityName;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.commodityName + ", " + this.sellIn + ", " + this.quality;
    }

    void updateCommodityItemQuality() {
        if (commodityName.equals("Sulfuras, Hand of Ragnaros")) {
            return;
        }

        if (commodityName.equals("Aged Brie")) {
            updateAgedBrieQuality();
            return;
        }

        if (commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            updateBackstageQuality();
            return;
        }

        updateCommonQuality();
    }

    private void updateCommonQuality() {
        if (quality > 0) quality--;
        sellIn--;
        if (sellIn < 0 && quality > 0) quality = quality - 1;
    }

    void updateAgedBrieQuality() {
        sellIn--;
        if (50 > quality) quality = quality + 1;
        if (0 > sellIn && quality < 50) quality = quality + 1;
    }

    void updateBackstageQuality() {
        if (quality < 50) {
            quality = quality + 1;
            if (sellIn < 11 && quality < 50) quality++;
            if (sellIn < 6 && quality < 50) quality++;
        }

        sellIn--;
        if(sellIn < 0) quality = 0;
    }
}
