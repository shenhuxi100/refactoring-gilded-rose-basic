package cn.xpbootcamp.gilded_rose;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@Data
public class CommodityItem {
    private String commodityName;
    private int sellIn;
    private int quality;

    private static Map<String, CalculateCommodityQuality> ioc = new HashMap<>();

    static {
        ServiceLoader<CalculateCommodityQuality> serviceLoader = ServiceLoader.load(CalculateCommodityQuality.class);
        serviceLoader.forEach(service -> ioc.put(service.getCommodityName(), service));
    }

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
        if (ioc.get(this.getCommodityName()) != null)
            ioc.get(this.getCommodityName()).calculateCommodityQuality(this);
        else
            ioc.get("Others").calculateCommodityQuality(this);
    }
}
