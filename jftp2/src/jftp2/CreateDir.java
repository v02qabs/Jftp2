package jftp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Scanner;

import it.sauronsoftware.ftp4j.FTPClient;


class CreateDir{
    public CreateDir(){}
    public void create_dir(){
	try{
                BufferedReader br = new BufferedReader(new FileReader("/home/user/userpass.txt"));
		FTPClient client = new FTPClient();
                String data_ftp = br.readLine();
                String array_ftp[] = data_ftp.split(",");
                String name = array_ftp[0];
                String pass = array_ftp[1];
                String server = array_ftp[2];
		client.connect(server);
		System.out.println(server);
		client.login(name, pass);
		System.out.println("name " + "\n" + "pass");
		System.out.println(name + "\n" + pass + "\n");
		Scanner scan_dir = new Scanner(System.in);
		String dir_server = scan_dir.next();
		client.createDirectory(dir_server);
		System.out.println("成功。");
	}catch(Exception error){
		System.out.println("mkdir error");
		System.out.println(error.toString());
	}

	
    }
}

