import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class PhoneBillTest {

	private BillCal cal;
	
	@Before
	public void setUp(){
		cal = new BillCal();
	}
	
	/**
	 * plan type ���� test
	 */
	/*@Test
	public void setPlanType_Test(){
		assertEquals(true, cal.setPlanType("SIlver"));
	}*/

	/**
	 * 1ȸ�� gold plan �� ���� bill ��� test
	 */
	@Test
	public void basic_Bill_Test_GoldOneLine() {
		//cal.setPlanType("Gold");
		//cal.setLine(1);
		cal.setAccount("Gold", 1, 0);
		Double resualt = 49.95;
		Double bill = cal.basic_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * 1ȸ�� silver plan �� ���� bill ��� test
	 */
	@Test
	public void basic_Bill_Test_SilverOneLine() {
		//cal.setPlanType("Silver");
		//cal.setLine(1);
		cal.setAccount("Silver", 1, 0);
		Double resualt = 29.95;
		Double bill = cal.basic_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * ��ȸ�� gold plan�� ���� �߰���� ��� test
	 */
	@Test
	public void addLine_Bill_Test_GoldAddLine() {
		//cal.setPlanType("Gold");
		//cal.setLine(2);
		cal.setAccount("Gold", 2, 0);
		Double resualt = 14.50;
		Double bill = cal.addLine_Bill();
		assertEquals(resualt, bill);
	}

	/**
	 * ��ȸ�� Silver plan�� ���� �߰���� ���  test
	 */
	@Test
	public void addLine_Bill_Test_SilverAddLine() {
		//cal.setPlanType("Silver");
		//cal.setLine(3);
		cal.setAccount("Silver", 3, 0);
		Double resualt = 43.0;
		Double bill = cal.addLine_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * Silver �ʰ����� ��ȭ�� ��� ��� test
	 */
	@Test
	public void ExcessMinBill_Test_NoExcess() {
		//cal.setPlanType("Silver");
		//cal.setLine(1);
		//cal.setMin(499);
		cal.setAccount("Silver", 1, 499);
		Double resualt = 0.0;
		Double bill = cal.excessMinute_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * Gold �⺻ ��ȭ�� ��� �� �� ��  �߰� ��� ��� test
	 */
	@Test
	public void ExcessMinBill_Test_Same() {
		//cal.setPlanType("GOld");
		//cal.setLine(1);
		//cal.setMin(1000);
		cal.setAccount("Gold", 1, 1000);
		Double resualt = 0.0;
		Double bill = cal.excessMinute_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * Gold �ʰ� ��ȭ��  �߰� ��� ��� test
	 */
	@Test
	public void ExcessMinBill_Test_Excess() {
		//cal.setPlanType("GOld");
		//cal.setLine(1);
		//cal.setMin(1010);
		cal.setAccount("Gold", 1, 1010);
		Double resualt = 4.5;
		Double bill = cal.excessMinute_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * Silver �������� ��� test
	 */
	@Test
	public void addLine_Bill_Test_FamilyDiscount() {
		//cal.setPlanType("Silver");
		//cal.setLine(5);
		//cal.setMin(500);
		cal.setAccount("Silver", 5, 500);
		Double resualt = 53.0;
		Double bill = cal.addLine_Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 *  Gold ��ü ���
	 */
	@Test
	public void Bill_Test_Gold() {
		/*cal.setPlanType("Gold");
		cal.setLine(4);
		cal.setMin(1123);*/
		cal.setAccount("Gold", 4, 1123);
		Double resualt = 139.3;
		Double bill = cal.Bill();
		assertEquals(resualt, bill);
	}
	
	/**
	 * setPlanType, setLine, setMin�� �����ھȿ� �ְ�, 
	 * �������� ���ڸ� ���ؼ� account�� �����ϵ��� ����.
	 */
}
