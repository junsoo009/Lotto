package Lotto_Write_JSON;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import Lotto_Number.Lotto_number;

public class Lotto_write_json implements Lotto_write {
	
	private final int turn = 800; // 800ȸ ���� �ζǹ�ȣ ����
	
	private JSONArray lottoarray;

	private JSONObject object;
	private InputStreamReader isr;

	private JSONParser parser;

	public Lotto_write_json() {

	}

	public void first_list_add() { // �ζǹ�ȣ ���� ( json )
		URL result;

		int addturn = turn;

		lottoarray = new JSONArray();
		try {

			while (true) {

				result = new URL("http://www.nlotto.co.kr/common.do?method=getLottoNumber&drwNo=" + addturn);

				isr = new InputStreamReader(result.openConnection().getInputStream());

				object = (JSONObject) JSONValue.parse(isr);

				if ("success".equals(object.get("returnValue"))) {
					System.out.print(turn + "ȸ�� �ζ� ��ȣ :");
					for (int i = 1; i <= 6; i++) {
						System.out.print(" " + object.get("drwtNo" + i));
					}
					System.out.println(" (���ʽ� : " + object.get("bnusNo") + ")");

				} else {
					System.out.println(turn + "ȸ�� �ζ� ���� �б⸦ �����Ͽ����ϴ�.");
					break;
				}
				lottoarray.add(object);
				addturn++;

			}

			object.clear();
			isr.close();
			System.out.println("=======================================================");
			System.out.println("�ζǹ�ȣ �������� �Ϸ�\n");

			FileWriter writer = new FileWriter("Lotto_Info\\lottoinfo.json");
			writer.write(lottoarray.toString());
			writer.close();

			System.out.println("=======================================================");
			System.out.println("json ���� �Ϸ�");
			System.out.println("=======================================================\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
