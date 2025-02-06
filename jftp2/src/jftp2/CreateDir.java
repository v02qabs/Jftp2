package jftp2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


class CreateDir{
    public CreateDir(){}
    public void create_dir(File f){
        System.out.println("created dir : " + f.getAbsolutePath().toString());
    }
}

