package ru.nsc.bionet.kegg_id_finder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class id_finder {
	
    public static String httpGet(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        if (conn.getResponseCode() != 200) {
            throw new IOException(conn.getResponseMessage());
        } // Buffer the result into a string
        BufferedReader rd = new BufferedReader(new InputStreamReader(
           conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        return sb.toString();
    }


	public static void main(String[] args) {
		String request = "http://rest.kegg.jp/list/hsa"; //������ ����� ������
		String request_out = ""; //��������� ����� � ������
		String rq_arr[]; // ... � ������
		List<String> rq_list = new ArrayList<String>(); // ... � ����
		try {
            String str = httpGet(request);
            System.out.println(str);
            request_out.concat(str);
            rq_list.
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		StringTokenizer r_out = new StringTokenizer(request_out, "\n"); //��������� �� ������
		
		/*
		 * ��������� ������ ����� �� �����
		 */
		BufferedReader reader;
		try {
		reader = new BufferedReader(new FileReader("gene_list.txt"));
		String line = "";
		while ((line = reader.readLine()) != null) { //��������� �������� �� �����
		    System.out.println("Line: "+line+
		    " : has "+line.length()+" length");
		}
		}
		catch (IOException e) {
		    e.printStackTrace();
		}
		
	
	}

}
