import java.awt.Desktop.Action;

/**
 * �ϳ��� Account�� 1�� �޴���ȭ ����� ����ϴ� class
 * @author sec
 *
 */
public class BillCal {
	/**
	 * ����� ������ ����.
	 */
	private Account account;

	public BillCal(){
		this.account = new Account();
	}
	
	/**
	 * ����� ������ ������ setting�ϴ� �Լ�
	 * @param plan ������ plan type
	 * @param lines ������ ��ȭ ȸ�� ��
	 * @param minutes ������ ����� ��ȭ �м�
	 */
	public void setAccount(String plan, int lines, int minutes){
		this.account.setPlanType(plan);
		this.account.setLines(lines);
		this.account.setUsedMinutes(minutes);
	}

	/**
	 * ������ ��ü ����� ����ϴ� �Լ�
	 * @return ��ü ���(double)
	 */
	public double Bill(){
		double total_bill = 0;
		total_bill += basic_Bill();//�⺻���
		total_bill += addLine_Bill();//�������� ������ ȸ���� ���� �߰���� 
		total_bill += excessMinute_Bill();//�߰� ��ȭ���� ���� �߰� ���
		account.setBill(total_bill);
		return total_bill;
	}
	
	/**
	 * ������ �⺻ ����� ������ �Լ�
	 * @return account�� plan�� ���� �⺻ ���
	 */
	public double basic_Bill(){
		return Plan.BASIC_RATE.getValue(account.getPlanType()); 
	}
	
	/**
	 * ������ �߰� ȸ���� ���� ����� ������ �Լ�
	 * ���� ���� �κе� �� ����.
	 * �ֿ� ȸ���� �����ϰ� 3��° ȸ������ �������� ����.
	 * @return ������ �߰� ȸ�� ��ݰ� �������� ����� ����� ��
	 */
	public double addLine_Bill(){
		int index;
		double add_bill = 0;
		//�߰� ȸ���� ���� ��� ��� 
		for(index = 1; index < account.getLines(); index++){
			if(index <= 2) //���� ���� �� ��� ȸ��
				add_bill += Plan.ADDLINE_RATE.getValue(account.getPlanType());
			else if(index > 2) //���� ���� ��� ȸ��
				add_bill += Plan.FAMILY_DISCOUNT.getValue(account.getPlanType());
		}
		return add_bill; 
	}
	
	/**
	 *������ �߰� ��ȭ���� ���� �߰� ����� ����� �Լ�
	 * @return ������ �߰� ��ȭ��
	 */
	public double excessMinute_Bill(){
		//�߰� ��ȭ�� (������ ����� ��ȭ�� - �⺻ ������)
		double excessMin = account.getUsedMinutes()-Plan.SERVICE_MINUTE.getValue(account.getPlanType());
		if(excessMin <= 0) //�����̸� �⺻ �������� �� ���� ���� ���
			return 0.0;//�߰���� ����
		
		return excessMin*Plan.EXCESSMIN_RATE.getValue(account.getPlanType());
	}

}
