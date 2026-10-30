package domain;

public class Board {
	private int noticeNo;
	private String noticeName;
	private String noticeTitle;
	private String noticeForm;
	private String noticeImage;
	private int noticeView;
	private String noticeDate;
	private String noticeUpdate;
	
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeImage() {
		return noticeImage;
	}
	public void setNoticeImage(String noticeImage) {
		this.noticeImage = noticeImage;
	}
	public int getNoticeView() {
		return noticeView;
	}
	public void setNoticeView(int noticeView) {
		this.noticeView = noticeView;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeUpdate() {
		return noticeUpdate;
	}
	public void setNoticeUpdate(String noticeUpdate) {
		this.noticeUpdate = noticeUpdate;
	}
	public String getNoticeName() {
		return noticeName;
	}
	public void setNoticeName(String noticeName) {
		this.noticeName = noticeName;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeForm() {
		return noticeForm;
	}
	public void setNoticeForm(String noticeForm) {
		this.noticeForm = noticeForm;
	}
	@Override
	public String toString() {
		return "Board [noticeNo=" + noticeNo + ", noticeName=" + noticeName + ", noticeTitle=" + noticeTitle
				+ ", noticeForm=" + noticeForm + ", noticeImage=" + noticeImage + ", noticeView=" + noticeView
				+ ", noticeDate=" + noticeDate + ", noticeUpdate=" + noticeUpdate + "]";
	}
	
	
}
