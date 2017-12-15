package lvzhn.entity;

import java.math.BigDecimal;

public class Goods {
    private Integer goodsid;

    private String goodsname;

    private BigDecimal stdptrice;

    private BigDecimal marketprice;

    private String pictureurl;

    private BigDecimal stocknums;

    private Integer classid;

    private String ishotsell;

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname == null ? null : goodsname.trim();
    }

    public BigDecimal getStdptrice() {
        return stdptrice;
    }

    public void setStdptrice(BigDecimal stdptrice) {
        this.stdptrice = stdptrice;
    }

    public BigDecimal getMarketprice() {
        return marketprice;
    }

    public void setMarketprice(BigDecimal marketprice) {
        this.marketprice = marketprice;
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }

    public BigDecimal getStocknums() {
        return stocknums;
    }

    public void setStocknums(BigDecimal stocknums) {
        this.stocknums = stocknums;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getIshotsell() {
        return ishotsell;
    }

    public void setIshotsell(String ishotsell) {
        this.ishotsell = ishotsell == null ? null : ishotsell.trim();
    }
}