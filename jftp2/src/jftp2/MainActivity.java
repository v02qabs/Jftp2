package jftp2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class MainActivity {
	String Command,File_Path;
	private String string_command;
	private String string_path;
	public MainActivity() {
		// TODO 自動生成されたコンストラクター・スタブ
		System.out.println("コマンドを入力せよ。");
		Scanner scan_command = new Scanner(System.in);
		string_command = scan_command.next();
		System.out.println("パスを入力せよ。");
		Scanner scan_path = new Scanner(System.in);
		string_path = scan_path.next();
		if(string_command.equals("add")) {
			
			System.out.println("ファイルを追記します。");
			if(string_path.equals(".")) {
				System.out.println("カレントリディレクトリ");
				write_dir();
			}
		}
		else if(string_command.equals("setup-user")) {
			System.out.println("サーバー名");
			Scanner scan_server = new Scanner(System.in);
			String server_string = scan_server.next();
		}
	}

	private void write_dir() {
		// TODO 自動生成されたメソッド・スタブ
		try {
			String os = System.getProperty("os.name");
			System.out.println(os);
			if(os.equals("Linux")) {
				System.out.println("OSはリナックスです。");
				String string_home = System.getProperty("user.home");
				System.out.println("ホームフォルダー：" + string_home);
				File file = new File(string_home);
				File[] list = file.listFiles();
				for(File flist : list) {
					System.out.println("file " + flist.toString());
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string_home + "/write_dir.txt")));
					bw.write(flist.toString());
					bw.close();
				}
				
				}
			else {
				if(os.equals("Windows")) {
					System.out.println("Windows");
					String string_home2 = System.getProperty("user.home");
					System.out.println("windows: " + string_home2);
					BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string_home2 + "/write_dir.txt")));
					bw.write("jall");
					bw.close();
				}
			}
			
		}catch(Exception error) {
			System.out.println("error." + error.toString() );
		}
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("Hello my jftp2");
		new MainActivity();
	}

}
