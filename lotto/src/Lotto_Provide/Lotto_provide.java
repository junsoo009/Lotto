package Lotto_Provide;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;

public interface Lotto_provide { // 향후 분석방법이 추가될때마다 메소드 추가
	
	public Lotto_number result(ArrayList lottolist); // 분석한 로또번호 추출 ( 빈도수가 가장 없는 번호 추출 ) 
	
}
