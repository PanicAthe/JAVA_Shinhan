package com.shinhan.day14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiExample {

	public static void main(String[] args) throws IOException {

		
		String strUrl1 = "https://api.bithumb.com/v1/trades/ticks?market=";
		String strUrl2 = "https://api.bithumb.com/v1/market/all";
		URL url = new URL(strUrl2);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET"); // 요청 방식 설정

		//conn.setRequestProperty("Accpet", "applicaiton/json");

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line;

		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		JSONArray jsonArr = new JSONArray(sb.toString());
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject obj = jsonArr.getJSONObject(i);
			//System.out.println(obj);
			String market = obj.getString("market");
			String name = obj.getString("korean_name");
			System.out.printf("마켓: %-10s 이름: %-15s", market, name);


			
			printPrice(market);
		
		}
		

	}

	private static void printPrice(String str) throws IOException {
		String strUrl = "https://api.bithumb.com/v1/trades/ticks?market="+str;
		URL url = new URL(strUrl);

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestMethod("GET"); // 요청 방식 설정

		conn.setRequestProperty("Accpet", "applicaiton/json");

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		String line;

		StringBuffer sb = new StringBuffer();
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}

		List list = new ArrayList<String>();
		JSONArray jsonArr = new JSONArray(sb.toString());
		for (int i = 0; i < jsonArr.length(); i++) {
			JSONObject obj = jsonArr.getJSONObject(i);
			int price = obj.getInt("trade_price");
			System.out.print("채결가: " + price+"\n");
		}
		
	}

}
