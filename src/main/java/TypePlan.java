/**
 * Account�� Type�� ������ �� ����ϴ� ���� ����
 * @author jungeun
 */
enum Type{
	GOLD,SILVER;
	private int value;
	public int getValue(){
		return this.value;
	}
};

/**
 * Bill�� ����� �� ���Ǵ� Plan�� ���� ������ ������ enum.
 * @author jungeun
 *
 */
enum Plan{
	/**
	 * Plan�� �Ŵ� �����ؾ� �ϴ� �⺻ ��� 
	 */
	BASIC_RATE{
		public double getValue(Type type){
			if(isGold(type))
				return 49.95;
			else if(isSilver(type))
				return 29.95;
			return 0.0;
		}
	},
	/**
	 * Plan�� �Ŵ� �����ؾ� �ϴ� �߰� ȸ���� �߰� ���
	 */
	ADDLINE_RATE{
		public double getValue(Type type){
			if(isGold(type))
				return 14.5;
			else if(isSilver(type))
				return 21.5;
			return 0.0;
		}
	},
	/**
	 * Plan�� �Ŵ� �����ؾ� �ϴ� �⺻ ���� ��ȭ��
	 */
	SERVICE_MINUTE {
		public double getValue(Type type){
			if(isGold(type))
				return 1000;
			else if(isSilver(type))
				return 500;
			return 0.0;
		}
	},
	/**
	 * Plan�� �Ŵ� �����ؾ� �ϴ� �߰� ��ȭ���� ���� �߰� ���(��)
	 */
	EXCESSMIN_RATE {
		public double getValue(Type type){
			if(isGold(type))
				return 0.45;
			else if(isSilver(type))
				return 0.54;
			return 0.0;
		}
	},
	/**
	 * Plan�� �������ִ� ���� ���� ��(Plan Type�� ��� ���� 5.0$)
	 */
	FAMILY_DISCOUNT{
		@Override
		double getValue(Type type) {
			return 5.0;
		}
	};
	
	/**
	 * Plan eunm���� PlanType�� ���� �ٸ� ���� return �ϱ� ���� get�Լ�.
	 * @param type Type�� �޾ƿ�  �ش� Type�� ���� return �� ����.
	 * @return double (Type�� �������� �ʴ� ��쿡�� 0 return)
	 */
	abstract double getValue(Type type);

	/**
	 * Type�� Gold�� �´����� ���� boolean���� return�ϴ� �Լ�
	 * @param type : Plan Type�� ��Ÿ��.(Gold, Silver)
	 * @return true/false
	 */
	static private boolean isSilver(Type type) {
		return type.equals(Type.SILVER);
	}

	/**
	 * Type�� Gold�� �´����� ���� boolean���� return�ϴ� �Լ�
	 * @param type : Plan Type�� ��Ÿ��.(Gold, Silver)
	 * @return true/false
	 */
	static private boolean isGold(Type type) {
		return type.equals(Type.GOLD);
	}
};


/**
 * Gold(Plan Type)�� ������ ������� ����
 * @author jungeun
 *//*
*//**
 * @author sec
 *
 *//*
enum Gold{
	*//**
	 * Gold Plan �� �Ŵ� �����ϴ� �⺻ ���
	 *//*
	BASIC_RATE(49.95),
	*//**
	 * Gold Plan �� �߰� ȸ���� �����ϴ� �߰� ���
	 *//*
	ADDLINE_RATE (14.50),
	*//**
	 * Gold Plan �� �Ŵ� �����ϴ� �⺻ ��ȭ��(��)
	 *//*
	SERVICE_MINUTE (1000),
	*//**
	 * Gold Plan �� �Ŵ� �����ϴ� �⺻ ��ȭ��(��)�� �ʰ��� ��� �д� �߰� ���
	 *//*
	EXCESSMIN_RATE (0.45);
	
	*//**
	 * Gold���� ���������� ���� ������ �� ���� ����
	 *//*
	private double value;
	
	*//**
	 * Gold���� ���������� ���� �����ϴ� ������
	 * @param value Gold���� ���������� ���� ������ �� ���� ����
	 *//*
	private Gold(double value){
		this.value = value;
	}
	
	*//**
	 * Gold�� Ư�� ���� ���� �� ����ϴ� �Լ�
	 * @return value
	 *//*
	public double getValue(){
		return this.value;
	}
};

*//**
 * Silver(Plan Type)�� ������ ������� ����
 * @author jungeun
 *//*
enum Silver{
	*//**
	 * Silver Plan �� �Ŵ� �����ϴ� �⺻ ���
	 *//*
	BASIC_RATE(29.95),
	*//**
	 * Silver Plan �� �߰� ȸ���� �����ϴ� �߰� ���
	 *//*
	ADDLINE_RATE (21.50),
	*//**
	 * Silver Plan �� �Ŵ� �����ϴ� �⺻ ��ȭ��(��)
	 *//*
	SERVICE_MINUTE (500),
	*//**
	 * Silver Plan �� �Ŵ� �����ϴ� �⺻ ��ȭ��(��)�� �ʰ��� ��� �д� �߰� ���
	 *//*
	EXCESSMIN_RATE (0.54);
	
	*//**
	 * Gold���� ���������� ���� ������ �� ���� ����
	 *//*
	private double value;
	
	*//**
	 * Gold���� ���������� ���� �����ϴ� ������
	 * @param value Gold���� ���������� ���� ������ �� ���� ����
	 *//*
	private Silver(double value){
		this.value = value;
	}
	
	*//**
	 * Gold�� Ư�� ���� ���� �� ����ϴ� �Լ�
	 * @return value
	 *//*
	public double getValue(){
		return this.value;
	}
};*/