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

    void commodityItemQualityMinusOne() {
        if (quality > 0 && !commodityName.equals("Sulfuras, Hand of Ragnaros")) {
            quality = quality - 1;
        }
    }

    void commodityItemQualityPlusOne() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    void handleSellInLessThanZero() {
        if (sellIn < 0) {
            if (commodityName.equals("Aged Brie")) {
                commodityItemQualityPlusOne();
            } else {
                if (commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    quality = 0;
                } else {
                    commodityItemQualityMinusOne();
                }
            }
        }
    }

    void handleQualityLessThan50() {
        if (quality < 50) {
            quality = quality + 1;

            if (commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (sellIn < 11) {
                    commodityItemQualityPlusOne();
                }

                if (sellIn < 6) {
                    commodityItemQualityPlusOne();
                }
            }
        }
    }

    void updateCommodityItemQuality() {
        if (commodityName.equals("Aged Brie")
                || commodityName.equals("Backstage passes to a TAFKAL80ETC concert")) {
            handleQualityLessThan50();
        } else {
            commodityItemQualityMinusOne();
        }

        if (!commodityName.equals("Sulfuras, Hand of Ragnaros")) {
            sellIn = sellIn - 1;
        }

        handleSellInLessThanZero();
    }
}
