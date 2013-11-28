/**
 * �޴���ȭ ������ ���� ����
 * @author jungeun
 */
public class Account{
	/**
	 * ������ ������ Plan�� Type����
	 * {@link Type}	 
	 */
	private Type planType;
	/**
	 * �ϳ��� ������ ������ �޴���ȭ ȸ�� ��
	 */
	private int lines;
	/**
	 * ������ 1�� ���
	 */
	private double bill;
	/**
	 * ������ ����� 1�� ��ȭ��
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