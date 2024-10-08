package catshap.butler.bean;

public class Basket {

	private int basketNo; // 장바구니번호
	private int userNo; // 사용자번호
	private int prodNo; // 상품번호
	private int baskAmt; // 수량
	private String proddescript;
	private String prodimgpath;
	private int prodPrice;

	public Basket() {
	}

	public Basket(int basketNo, int userNo, int prodNo, int baskAmt, String proddescript, String prodimgpath,
			int prodPrice) {
		super();
		this.basketNo = basketNo;
		this.userNo = userNo;
		this.prodNo = prodNo;
		this.baskAmt = baskAmt;
		this.proddescript = proddescript;
		this.prodimgpath = prodimgpath;
		this.prodPrice = prodPrice;
	}

	public int getBasketNo() {
		return basketNo;
	}

	public void setBasketNo(int basketNo) {
		this.basketNo = basketNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public int getBaskAmt() {
		return baskAmt;
	}

	public void setBaskAmt(int baskAmt) {
		this.baskAmt = baskAmt;
	}

	public String getProddescript() {
		return proddescript;
	}

	public void setProddescript(String proddescript) {
		this.proddescript = proddescript;
	}

	public String getProdimgpath() {
		return prodimgpath;
	}

	public void setProdimgpath(String prodimgpath) {
		this.prodimgpath = prodimgpath;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	@Override
	public String toString() {
		return "Basket [basketNo=" + basketNo + ", userNo=" + userNo + ", prodNo=" + prodNo + ", baskAmt=" + baskAmt
				+ ", proddescript=" + proddescript + ", prodimgpath=" + prodimgpath + ", prodPrice=" + prodPrice + "]";
	}

}
