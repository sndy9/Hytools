package com.sndy.Hytools.Compiler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Compiler {
    public static void Compile(String FilePath){
        String Contents = "";
        try{
            Contents = Files.readString(Paths.get(FilePath));
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

        Contents.split(";");
    }
}
