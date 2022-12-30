package main.java.com.solvd.vehiclefactory;

import java.util.Objects;

public class InventoryItem {
	
	private String itemID;
	private long count;
	
	public InventoryItem (String itemID, long count) {
		this.itemID = itemID;
		this.count = count;
		
	}
	
	@Override
	public String toString() {
		return ("[" + this.count + " " + this.itemID + "]");
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		if(obj == null || obj.getClass()!= this.getClass()) {
		        return false;
		}
		InventoryItem item = (InventoryItem) obj;
		return (item.itemID.equals(this.itemID)  && item.count == this.count);
		
	}
	
	@Override
    public int hashCode()
    {
        return Objects.hash(itemID, count);
    }

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}


}
