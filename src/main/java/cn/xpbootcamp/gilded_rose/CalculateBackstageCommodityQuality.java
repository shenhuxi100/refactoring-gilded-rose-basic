package cn.xpbootcamp.gilded_rose;

public class CalculateBackstageCommodityQuality implements CalculateCommodityQuality{
    @Override
    public String getCommodityName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    private final int DOUBLE_SELLIN_DAY = 11;
    private final int TRIPLE_SELLIN_DAY = 6;

    @Override
    public void calculateCommodityQuality(CommodityItem item) {
        if (item.getQuality() < Constants.MAX_QUALITY) {
            item.setQuality(item.getQuality() + 1);
            if (item.getSellIn() < DOUBLE_SELLIN_DAY && item.getQuality() < Constants.MAX_QUALITY) item.setQuality(item.getQuality() + 1);
            if (item.getSellIn() < TRIPLE_SELLIN_DAY && item.getQuality() < Constants.MAX_QUALITY) item.setQuality(item.getQuality() + 1);
        }

        item.setSellIn(item.getSellIn() - 1);
        if(item.getSellIn() < 0) item.setQuality(0);
    }
}
