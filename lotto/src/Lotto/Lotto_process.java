package Lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto_json_parse.Lotto_json;
import Lotto_json_parse.Lotto_json_process;

public class Lotto_process {

	private Lotto_json lottojson;

	private Lotto_provide lottoprovide;
	private Lotto_number lottonum;

	public Lotto_process() {
		lottonum = new Lotto_number();
		lottojson = new Lotto_json_process();
		lottoprovide = new Lotto_provide_num();
	}

	public Lotto_process(Lotto_provide lottoprovide) {
		lottojson.first_list_add();
	}

	public void lottoprovide() { // �ζ� ����� ���� �޼ҵ�

		ArrayList readlist = lottojson.read(); // �ζǹ�ȣ �б� ( ���� �б� )
		
		lottonum = lottoprovide.result(readlist); // �����

	}
}
