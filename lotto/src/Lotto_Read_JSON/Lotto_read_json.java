package Lotto_Read_JSON;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Lotto_Number.Lotto_number;

public class Lotto_read_json implements Lotto_read {

	final int LOTTO = 45;

	private JSONParser parser;
	private JSONArray obj;
	
	private Lotto_number lottonumber;
	private ArrayList lottoarray;
	
	public Lotto_read_json() {
		lottonumber = new Lotto_number();
		parser = new JSONParser();
		lottoarray = new ArrayList();
	}

	public ArrayList read() {
		System.out.println("=======================================================");

		System.out.println("읽기 시작\n");
		try {
			System.out.println("json start");

			JSONArray obj = (JSONArray) parser.parse(new FileReader("Lotto_Info\\lottoinfo.json"));

			System.out.println(obj);

			for (int i = 0; i < obj.size(); i++) {
				int[] lotto_temp = new int[7];
				JSONObject json_temp = (JSONObject) obj.get(i);

				lotto_temp[lotto_temp.length - 1] = Integer.parseInt(json_temp.get("bnusNo").toString());
				
				for (int j = 1; j < 7; j++) {
					lotto_temp[j - 1] = Integer.parseInt(json_temp.get("drwtNo" + j).toString());				

				}

				for (int j = 0; j < lotto_temp.length; j++)
					System.out.print(lotto_temp[j] + " ");
				System.out.println();

				lottoarray.add(lotto_temp);

			}
			
			System.out.println("리스트 종료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("=======================================================");
		System.out.println("읽기 종료");
		System.out.println("=======================================================\n");

		return lottoarray;
	}

}
