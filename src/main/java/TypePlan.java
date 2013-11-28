/**
 * Account의 Type을 저장할 때 사용하는 값을 정의
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
 * Bill을 계산할 때 사용되는 Plan에 대한 정보를 저장한 enum.
 * @author jungeun
 *
 */
enum Plan{
	/**
	 * Plan이 매달 지불해야 하는 기본 요금 
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
	 * Plan이 매달 지불해야 하는 추가 회선당 추가 요금
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
	 * Plan이 매달 지불해야 하는 기본 제공 통화량
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
	 * Plan이 매달 지불해야 하는 추가 통화량에 대한 추가 요금(분)
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
	 * Plan이 할인해주는 가족 할인 값(Plan Type에 상관 없이 5.0$)
	 */
	FAMILY_DISCOUNT{
		@Override
		double getValue(Type type) {
			return 5.0;
		}
	};
	
	/**
	 * Plan eunm에서 PlanType에 따라 다른 값을 return 하기 위한 get함수.
	 * @param type Type을 받아와  해당 Type에 따라 return 값 결정.
	 * @return double (Type이 존재하지 않는 경우에는 0 return)
	 */
	abstract double getValue(Type type);

	/**
	 * Type이 Gold가 맞는지에 대한 boolean값을 return하는 함수
	 * @param type : Plan Type을 나타냄.(Gold, Silver)
	 * @return true/false
	 */
	static private boolean isSilver(Type type) {
		return type.equals(Type.SILVER);
	}

	/**
	 * Type이 Gold가 맞는지에 대한 boolean값을 return하는 함수
	 * @param type : Plan Type을 나타냄.(Gold, Silver)
	 * @return true/false
	 */
	static private boolean isGold(Type type) {
		return type.equals(Type.GOLD);
	}
};


/**
 * Gold(Plan Type)가 가지는 상수들을 저장
 * @author jungeun
 *//*
*//**
 * @author sec
 *
 *//*
enum Gold{
	*//**
	 * Gold Plan 의 매달 지불하는 기본 요금
	 *//*
	BASIC_RATE(49.95),
	*//**
	 * Gold Plan 의 추가 회선당 지불하는 추가 요금
	 *//*
	ADDLINE_RATE (14.50),
	*//**
	 * Gold Plan 의 매달 제공하는 기본 통화량(분)
	 *//*
	SERVICE_MINUTE (1000),
	*//**
	 * Gold Plan 의 매달 제공하는 기본 통화량(분)을 초과할 경우 분당 추가 요금
	 *//*
	EXCESSMIN_RATE (0.45);
	
	*//**
	 * Gold에서 내부적으로 값을 저장할 때 쓰는 변수
	 *//*
	private double value;
	
	*//**
	 * Gold에서 내부적으로 값을 저장하는 생성자
	 * @param value Gold에서 내부적으로 값을 저장할 때 쓰는 변수
	 *//*
	private Gold(double value){
		this.value = value;
	}
	
	*//**
	 * Gold의 특정 값을 얻을 때 사용하는 함수
	 * @return value
	 *//*
	public double getValue(){
		return this.value;
	}
};

*//**
 * Silver(Plan Type)가 가지는 상수들을 저장
 * @author jungeun
 *//*
enum Silver{
	*//**
	 * Silver Plan 의 매달 지불하는 기본 요금
	 *//*
	BASIC_RATE(29.95),
	*//**
	 * Silver Plan 의 추가 회선당 지불하는 추가 요금
	 *//*
	ADDLINE_RATE (21.50),
	*//**
	 * Silver Plan 의 매달 제공하는 기본 통화량(분)
	 *//*
	SERVICE_MINUTE (500),
	*//**
	 * Silver Plan 의 매달 제공하는 기본 통화량(분)을 초과할 경우 분당 추가 요금
	 *//*
	EXCESSMIN_RATE (0.54);
	
	*//**
	 * Gold에서 내부적으로 값을 저장할 때 쓰는 변수
	 *//*
	private double value;
	
	*//**
	 * Gold에서 내부적으로 값을 저장하는 생성자
	 * @param value Gold에서 내부적으로 값을 저장할 때 쓰는 변수
	 *//*
	private Silver(double value){
		this.value = value;
	}
	
	*//**
	 * Gold의 특정 값을 얻을 때 사용하는 함수
	 * @return value
	 *//*
	public double getValue(){
		return this.value;
	}
};*/