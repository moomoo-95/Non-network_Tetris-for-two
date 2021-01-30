package tetris;

import java.io.*;

public class TetrisRank {
	private String path;
	
	public TetrisRank() {
		path = "./TetrisRankList.txt";
		
	}
	
	public void FileWrite () {
		try {
			FileWriter fw = new FileWriter(path, true);
			BufferedWriter bw = new BufferedWriter(fw);
			String newRank = "2 TES 2700 9";
			bw.write(newRank);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch ( IOException e) {
			TetrisLog.e(e.toString());
		}
	}
	
	public String[] FileRead () {
		String[] readRank = new String[10];
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);
			for(int i = 0; (readRank[i] = br.readLine()) != null; i++){
				System.out.println(readRank);
			}
			br.close();
		} catch ( IOException e) {
			TetrisLog.e(e.toString());
		}
		return readRank;
	}
}

class RankRecord{
	private int count;
	private int[] score;
	private String[] name;
	
	
	public RankRecord(int n) {
		this.count = n;
		this.score = new int[n];
		this.name = new String[n];
	}
}