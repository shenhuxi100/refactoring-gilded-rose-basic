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
        if (commodityName.equals("Aged Brie")) {
            updateAgedBrieQuality();
            return;
        }
        if (commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (quality < 50) {
                quality = quality + 1;

                if (sellIn < 11) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }

                if (sellIn < 6) {
                    if (quality < 50) {
                        quality = quality + 1;
                    }
                }
            }
        } else {
            if (quality > 0 && !commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                quality = quality - 1;
            }
        }

        if (!commodityName.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }

        if (sellIn < 0) {
            if (commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                quality = 0;
            } else {
                if (quality > 0 && !commodityName.equals("Sulfuras, Hand of Ragnaros")) {
                    quality = quality - 1;
                }
            }
        }
    }

    void updateAgedBrieQuality() {
        if (commodityName.equals("Aged Brie")){
            if (quality < 50) {
                quality = quality + 1;
            }
            sellIn = sellIn - 1;

            if (sellIn < 0) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
    }
}
