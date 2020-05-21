package cn.xpbootcamp.gilded_rose;

public class CalculateAgedBrieCommodityQuality implements CalculateCommodityQuality{
    @Override
    public String getCommodityName() {
        return "Aged Brie";
    }

    @Override
    public void calculateCommodityQuality(CommodityItem item) {
        item.setSellIn(item.getSellIn() - 1);
        if (Constants.MAX_QUALITY > item.getQuality()) item.setQuality(item.getQuality() + 1);
        if (0 > item.getSellIn() && item.getQuality() < Constants.MAX_QUALITY) item.setQuality(item.getQuality() + 1);
    }
}
