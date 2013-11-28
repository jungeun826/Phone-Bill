/**
 * 휴대전화 계정에 대한 정보
 * @author jungeun
 */
public class Account{
	/**
	 * 계정이 가입한 Plan의 Type정보
	 * {@link Type}	 
	 */
	private Type planType;
	/**
	 * 하나의 계정이 가지는 휴대전화 회선 수
	 */
	private int lines;
	/**
	 * 계정의 1달 요금
	 */
	private double bill;
	/**
	 * 계정이 사용한 1달 통화량
	 */
	private int usedMinutes;
	
	public Account(){
		
	}
	public Account(String planType, int lines, int minutes){
		this.lines = lines;
		this.usedMinutes = minutes;
	}
	
	public Type getPlanType() {
		return planType;
	}
	private void setPlanType(Type planType) {
		this.planType = planType;
	}
	public void setPlanType(String planType) {
		if(planType.toUpperCase().equals("GOLD"))
			this.setPlanType(Type.GOLD);
		else if(planType.toUpperCase().equals("SILVER"))
			this.setPlanType(Type.SILVER);
	}
	
	
	public int getLines() {
		return lines;
	}
	public void setLines(int lines) {
		this.lines = lines;
	}
	
	public double getBill() {
		return bill;
	}
	public void setBill(double bill) {
		this.bill = bill;
	}
	
	public int getUsedMinutes() {
		return usedMinutes;
	}
	public void setUsedMinutes(int usedMinutes) {
		this.usedMinutes = usedMinutes;
	}
}