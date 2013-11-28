import java.awt.Desktop.Action;

/**
 * 하나의 Account의 1달 휴대전화 요금을 계산하는 class
 * @author sec
 *
 */
public class BillCal {
	/**
	 * 계산할 계정의 정보.
	 */
	private Account account;

	public BillCal(){
		this.account = new Account();
	}
	
	/**
	 * 계산할 계정의 정보를 setting하는 함수
	 * @param plan 계정의 plan type
	 * @param lines 계정의 전화 회선 수
	 * @param minutes 계정이 사용한 통화 분수
	 */
	public void setAccount(String plan, int lines, int minutes){
		this.account.setPlanType(plan);
		this.account.setLines(lines);
		this.account.setUsedMinutes(minutes);
	}

	/**
	 * 계정의 전체 요금을 계산하는 함수
	 * @return 전체 요금(double)
	 */
	public double Bill(){
		double total_bill = 0;
		total_bill += basic_Bill();//기본요금
		total_bill += addLine_Bill();//가족할인 적용한 회선에 따른 추가요금 
		total_bill += excessMinute_Bill();//추가 통화량에 따른 추가 요금
		account.setBill(total_bill);
		return total_bill;
	}
	
	/**
	 * 계정의 기본 요금을 얻어오는 함수
	 * @return account의 plan에 따른 기본 요금
	 */
	public double basic_Bill(){
		return Plan.BASIC_RATE.getValue(account.getPlanType()); 
	}
	
	/**
	 * 계정의 추가 회선에 따른 요금을 얻어오는 함수
	 * 가족 할인 부분도 들어가 있음.
	 * 주요 회선을 제외하고 3번째 회선부터 가족할인 적용.
	 * @return 계정의 추가 회선 요금과 가족할인 요금이 적용된 값
	 */
	public double addLine_Bill(){
		int index;
		double add_bill = 0;
		//추가 회선에 따라 요금 계산 
		for(index = 1; index < account.getLines(); index++){
			if(index <= 2) //가족 할인 비 대상 회선
				add_bill += Plan.ADDLINE_RATE.getValue(account.getPlanType());
			else if(index > 2) //가족 할인 대상 회선
				add_bill += Plan.FAMILY_DISCOUNT.getValue(account.getPlanType());
		}
		return add_bill; 
	}
	
	/**
	 *계정의 추가 통화량에 따른 추가 요금을 얻오는 함수
	 * @return 계정의 추가 통화량
	 */
	public double excessMinute_Bill(){
		//추가 통화량 (계정이 사용한 통화량 - 기본 제공량)
		double excessMin = account.getUsedMinutes()-Plan.SERVICE_MINUTE.getValue(account.getPlanType());
		if(excessMin <= 0) //음수이면 기본 제공량을 다 쓰지 않은 경우
			return 0.0;//추가요금 없음
		
		return excessMin*Plan.EXCESSMIN_RATE.getValue(account.getPlanType());
	}

}
