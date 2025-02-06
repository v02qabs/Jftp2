package jftp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;
class MainActivity{
	public static void main(String[] args) {
		new MainActivity();
	}
	public Scanner scan;
	private String Username;
	private String pass;
	
	private String server;
	private String string_home = System.getProperty("user.home");
	
	public MainActivity() {
		System.out.println("start listing file.");
		System.out.println("type the command");
		scan = new Scanner(System.in);
		String string_command = scan.next();

		if(string_command.equals("add")) {
			setfile();
		}else if ( string_command.equals("user-create")) {
			System.out.println("user create");
			create_user();
		}
		else if(string_command.equals("help")) {
			System.out.print("java jftp2.MainActivity");
			System.out.print("\n" + "add \n user-create \n" + "help");
		}
        else if(string_command.equals("create-dir")){
            Scanner scan_dir = new Scanner(System.in);
            String string_dir = scan_dir.next();
            new CreateDir().create_dir(new File(string_dir));
        }
		else if(string_command.equals("push")){
			//FTPClient client = new FTPClient();
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(string_home +  "/userpass.txt")));
				String data_ftp = br.readLine();
				String array_ftp[] = data_ftp.split(",");
				String name = array_ftp[0];
				String pass = array_ftp[1];
				String server = array_ftp[2];
				System.out.println("write data....");
				System.out.print("data\n" + "name : " + name + " \n"+ "pass " + pass + " \n"+ "server " + server );
				//FTPClient client = new FTPClient();
				br.close();
				 client = new FTPClient();
				client.connect(server);
				client.login(name,pass);
				String array_flist_top [] = client.listNames();
				for(String list : array_flist_top){
					System.out.println("list : " + list);
					client.changeDirectory("/public_html");
					String array_list3[] = client.listNames();
					for(String s : array_list3){
						System.out.println("list3 : " + s);
					}

				}

			}
			catch(Exception error) {
				System.out.println("connection error");
			}
		}
 

	}
	private FTPClient client;
	private void create_user() {
		// TODO 自動生成されたメソッド・スタブ
		Scanner user_scan = new Scanner(System.in);
		System.out.println("user name");
		Username = user_scan.next();
		Scanner pass_scan = new Scanner(System.in);
		System.out.println("password");
		pass = pass_scan.next();
		System.out.println("ftp server");
		Scanner scan_server = new Scanner(System.in);
		server = scan_server.next();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(string_home + "/userpass.txt")));
			bw.write(Username + "," + pass + "," + server);
			bw.close();
		}catch(Exception error)
		{
			
		}
	}
	private void setfile() {
		File f = new File("./");
		if(f.isDirectory()) {
			String flist1[] = f.list();
			for(String s: flist1) {
			//	System.out.println("s " + s);
				//setfile(new File(s));
				try {
				continue;
				}catch(Exception error)
				{
					System.out.println("error");
				}
			}
		}
		else if (f.isFile()) {
			String flists[] = f.list();
			System.out.println("[f] " + flists);
		}
	}
	private void setfile(File file) {
		// TODO 自動生成されたメソッド・スタブ
		try {
			
		File[] f = file.listFiles();
		for(File f2 : f) {
			System.out.println("f2 " + f2.getAbsolutePath());
			setfile(f2);
		}
		}catch(Exception error) {}
	}
	private void loop(File f) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("new " + f.getName());
		
	}
}
