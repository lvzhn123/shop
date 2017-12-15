package lvzhn.entity;

import java.math.BigDecimal;
import java.util.List;

public class ShopCart {
	private Integer id;

	private Integer userid;

	private BigDecimal nums;

	private BigDecimal amount;

	private List<ShopCartDetail> shopCartDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public BigDecimal getNums() {
		return nums;
	}

	public void setNums(BigDecimal nums) {
		this.nums = nums;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public List<ShopCartDetail> getShopCartDetails() {
		return shopCartDetails;
	}

	public void setShopCartDetails(List<ShopCartDetail> shopCartDetails) {
		this.shopCartDetails = shopCartDetails;
	}
}