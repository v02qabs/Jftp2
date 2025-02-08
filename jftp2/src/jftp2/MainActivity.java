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
	String string_files;
	private File f = new File(string_home + "/git/jftp2/jftp2/.");
	public MainActivity() {
		System.out.println("start listing file.");
		System.out.println("type the command");
		scan = new Scanner(System.in);
          File files = new File("/home/user/git/jftp2/jftp2/src/t/./log");
		String string_command = scan.next();

		if(string_command.equals("add")) {
			
            		File[] flist = f.listFiles();
            		for(File f : flist){
            			System.out.println("ok");
            			 try{
            			 BufferedWriter bw = new BufferedWriter(new FileWriter(files));
            			 bw.write(f.getName().toString() + "\n");
            			 
            			 bw.close();
            			 }catch(Exception error){
            			 System.out.println("error" + error.toString());
            			 }
            			 
            			 
            			 
            			 if(f.isDirectory()){
            			 	continue;
				}
				else if(f.isFile()){
				System.out.println("f " + f.getName());
					try{
						BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("/home/user/write.txt")));
						bw1.write(f.getName());
						
						bw1.close();
					}	
					catch(Exception error){}
					
				
				}
				
				
				
            	
            					
            				
                      	}
                
			

		}else if ( string_command.equals("user-create")) {
			System.out.println("user create");
			create_user();
		}
		else if(string_command.equals("help")) {
			System.out.print("java jAZqqqqqftp2.MainActivity");
			System.out.print("\n" + "add \n user-create \n" + "help");
		}
        else if(string_command.equals("create-dir")){
            Scanner scan_dir = new Scanner(System.in);
            String string_dir = scan_dir.next();
            new CreateDir().create_dir(new File(string_dir));
        }
		else if(string_command.equals("push")){
			 client = new FTPClient();
			try {
				BufferedReader br = new BufferedReader(new FileReader(new File(string_home +  "/userpass.txt")));
				String data_ftp = br.readLine();
				String array_ftp[] = data_ftp.split(",");
				String name = array_ftp[0];
				String pass = array_ftp[1];
				String server = array_ftp[2];
				System.out.println("write data....");
				System.out.print("data\n" + "name : " + name + " \n"+ "pass " + pass + " \n"+ "server " + server );
				 //client = new FTPClient();
				 System.out.println("send dir");
				client.connect(server);
				client.login(name,pass);
				 Scanner sends_dir = new Scanner(System.in);
				 String scand_dir = sends_dir.next();
				 client.changeDirectory(scand_dir);
                Scanner scan_up_files = new Scanner(System.in);
                   String string_up_files = scan_up_files.next);
                client.upload(new File(string_up_files));


			}
			catch(Exception error) {
				System.out.println("connection error" + error.toString());
			}
		}
 

	}
    //private FTPClient client;
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
		

	
	}
