package cn.xpbootcamp.gilded_rose;

public class CalculateCommonCommodityQuality implements CalculateCommodityQuality{
    @Override
    public String getCommodityName() {
        return "Others";
    }

    @Override
    public void calculateCommodityQuality(CommodityItem item) {
        if (item.getQuality() > 0) item.setQuality(item.getQuality() - 1);
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() > 0) item.setQuality(item.getQuality() - 1);
    }
}
