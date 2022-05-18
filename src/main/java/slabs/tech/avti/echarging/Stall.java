package slabs.tech.avti.echarging;

import java.util.Map;

public class Stall {
	
	private long usageTime;
	private long id;
	private Map<Long,Double> rate;
	
	
	public long getUsageTime() {
		return usageTime;
	}
	public void setUsageTime(long usageTime) {
		this.usageTime = usageTime;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Map<Long, Double> getRate() {
		return rate;
	}
	public void setRate(Map<Long, Double> rate) {
		this.rate = rate;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
