package domain;


public class Order {
	
	private String sno;
	private String shopno;
	private String shopname;
	private String orderno;
	private String orderdate;
	private String pcode;
	private String pname;
	private String ordername;
	private int amount;
	private int cost;
	private int costPrice;
	private int discountPrice;
	
	
	
	public String getShopno() {
		return shopno;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getOrdername() {
		return ordername;
	}
	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}
	public void setShopno(String shopno) {
		this.shopno = shopno;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getCostPrice() {
		return costPrice;
	}
	public void setCostPrice(int costPrice) {
		this.costPrice = costPrice;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	@Override
	public String toString() {
		return "Order [sno=" + sno + ", shopno=" + shopno + ", shopname=" + shopname + ", orderno=" + orderno
				+ ", orderdate=" + orderdate + ", pcode=" + pcode + ", pname=" + pname + ", ordername=" + ordername
				+ ", amount=" + amount + ", cost=" + cost + ", costPrice=" + costPrice + ", discountPrice="
				+ discountPrice + "]";
	}
	
	
	
	

	
	
}
