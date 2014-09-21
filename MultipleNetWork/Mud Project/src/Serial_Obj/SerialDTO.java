package Serial_Obj;

import java.io.Serializable;

public class SerialDTO implements Serializable{
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2L;
	private String bookName;
	transient private int bookOrder;
	private boolean bestSeller;
	private long soldPerDay;
	private String bookTypes = "IT";
	public SerialDTO(String bookName, int bookOrder, boolean bestSeller, long soldPerDay) {
		super();
		this.bookName = bookName;
		this.bookOrder = bookOrder;
		this.bestSeller = bestSeller;
		this.soldPerDay = soldPerDay;
	}
	
	@Override
	public String toString() {
		
		return "SerialDTO [bookName = " + bookName + " bookOrde = " + bookOrder
				+ ", bestSeller = " + bestSeller + ", soldPerDay = " 
				+ soldPerDay + ", bookType = " + bookTypes + "]";				
	}	
}
