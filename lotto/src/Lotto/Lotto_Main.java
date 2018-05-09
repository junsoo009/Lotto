package Lotto;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;

public class Lotto_Main {

	public static void main(String[] args) {

		Lotto_provide lottoprovide = new Lotto_provide_num(); // 번호 추출 하라는 명령

		Lotto_process lottoprocess = new Lotto_process(lottoprovide); // 로또추출기 생성자

		lottoprocess.lottoprovide(); // 로또추출기 실행

	}

}
