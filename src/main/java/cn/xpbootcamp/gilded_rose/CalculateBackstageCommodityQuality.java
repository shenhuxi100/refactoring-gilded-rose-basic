package cn.xpbootcamp.gilded_rose;

public class CalculateBackstageCommodityQuality implements CalculateCommodityQuality{
    @Override
    public String getCommodityName() {
        return "Backstage passes to a TAFKAL80ETC concert";
    }

    @Override
    public void calculateCommodityQuality(CommodityItem item) {
        if (item.getQuality() < 50) {
            item.setQuality(item.getQuality() + 1);
            if (item.getSellIn() < 11 && item.getQuality() < 50) item.setQuality(item.getQuality() + 1);
            if (item.getSellIn() < 6 && item.getQuality() < 50) item.setQuality(item.getQuality() + 1);
        }

        item.setSellIn(item.getSellIn() - 1);
        if(item.getSellIn() < 0) item.setQuality(0);
    }
}
