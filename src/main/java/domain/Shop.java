package domain;

public class Shop {
	private String sno;
	private String sname;
	private int scount;
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public int getScount() {
		return scount;
	}
	public void setScount(int scount) {
		this.scount = scount;
	}
	@Override
	public String toString() {
		return "Shop [sno=" + sno + ", sname=" + sname + ", scount=" + scount + "]";
	}
	
	
}
