package cn.xpbootcamp.gilded_rose.service;

import cn.xpbootcamp.gilded_rose.CommodityItem;
import cn.xpbootcamp.gilded_rose.Constants;

public class CalculateCommonCommodityQuality implements CalculateCommodityQuality{
    @Override
    public String getCommodityName() {
        return "Others";
    }

    @Override
    public void calculateCommodityQuality(CommodityItem item) {
        if (item.getQuality() > Constants.MIN_QUALITY) item.setQuality(item.getQuality() - 1);
        item.setSellIn(item.getSellIn() - 1);
        if (item.getSellIn() < 0 && item.getQuality() > Constants.MIN_QUALITY) item.setQuality(item.getQuality() - 1);
    }
}
