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
    private File f1;
	private void setFiles(){
        System.out.println("setting files...");
        f1 = new File(string_home + "/logging.txt");



	File f2 = new File(".");
        String[] files = f2.list();
        for(String s : files){

          try{
          	 BufferedWriter bw4 = new BufferedWriter(new FileWriter(new File(string_home + "/logging.txt"), true));
           		bw4.write(s + "\n");
            		bw4.close();
            	
        }
        catch(Exception e)
	{
		System.out.println("e : " + e.toString());
	}

        }
        
        try{
        }
        catch(Exception e)
        {
            System.out.println("e"  + e.toString()); 
        } 
    }
	private String server, line2;
	private String string_home = System.getProperty("user.home");
	String string_files;
	private File f = new File(string_home + "log.txt");
	public MainActivity() 
       {
		System.out.println("start listing file.");
		System.out.println("type the command");
        	Scanner scan_command = new Scanner(System.in);
        	String string_command = scan_command.next();
		if(string_command.equals("add")) 
            	{
			setFiles();
            	}

	

		else if ( string_command.equals("user-create")) {
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
                		try{
                			BufferedReader br7 = new BufferedReader(new FileReader(new File(string_home + "/logging.txt")));
                			while((line2 = br7.readLine()) != null){
                			    System.out.println("line2 : " + line2);
                    				try{
                    					client.upload(new File(line2));
                    				}
                    				catch(Exception error){
                    					System.out.println("e : " + error.toString());
                    					}
                    					
                			}
                		}catch(Exception e){
                				System.out.println("e : "  + e.toString());
                		}
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


