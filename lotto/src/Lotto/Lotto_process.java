package Lotto;

import java.util.ArrayList;

import Lotto_Number.Lotto_number;
import Lotto_Provide.Lotto_provide;
import Lotto_Provide.Lotto_provide_num;
import Lotto_json_parse.Lotto_json;
import Lotto_json_parse.Lotto_json_process;

public class Lotto_process {

	private Lotto_json lottojson;

	private Lotto_number lottonum;

	public Lotto_process() {

	}

	public Lotto_process(Lotto_provide lottoprovide) { // �⺻���� ������ �м����� ������

		lottonum = new Lotto_number();
		lottojson = new Lotto_json_process();

		lottojson.first_list_add();

		ArrayList readlist = lottojson.read(); // �ζǹ�ȣ �б� ( ���� �б� )

		lottoprovide(readlist, lottoprovide);
	}

	public void lottoprovide(ArrayList readlist, Lotto_provide lottoprovide) { // �ζ� ����� ���� �޼ҵ�

		lottonum = lottoprovide.result(readlist); // �����

	}

	public int[] getLottonum() {
		return lottonum.getLottonum();
	}

}
