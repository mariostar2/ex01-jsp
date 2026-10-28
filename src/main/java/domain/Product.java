package domain;

public class Product {
	private String shopno;
	private String pcode;
	private String pname;
	private String cost;
	private int totalcount;
	private int discountPrice;
	private int dispriced;
	public String getShopno() {
		return shopno;
	}
	public void setShopno(String shopno) {
		this.shopno = shopno;
	}
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getDispriced() {
		return dispriced;
	}
	public void setDispriced(int dispriced) {
		this.dispriced = dispriced;
	}
	@Override
	public String toString() {
		return "Product [shopno=" + shopno + ", pcode=" + pcode + ", pname=" + pname + ", cost=" + cost
				+ ", totalcount=" + totalcount + ", discountPrice=" + discountPrice + ", dispriced=" + dispriced + "]";
	}
	

	
	
	
	
	
}
