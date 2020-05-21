package cn.xpbootcamp.gilded_rose.service;

import cn.xpbootcamp.gilded_rose.CommodityItem;

public class CalculateSulfurasCommodityQuality implements CalculateCommodityQuality{
    @Override
    public String getCommodityName() {
        return "Sulfuras, Hand of Ragnaros";
    }

    @Override
    public void calculateCommodityQuality(CommodityItem item) {
    }
}
