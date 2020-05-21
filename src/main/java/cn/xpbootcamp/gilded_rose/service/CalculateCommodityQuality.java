package cn.xpbootcamp.gilded_rose.service;

import cn.xpbootcamp.gilded_rose.CommodityItem;

public interface CalculateCommodityQuality {
    String getCommodityName();
    void calculateCommodityQuality(CommodityItem item);
}
