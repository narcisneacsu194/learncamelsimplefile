package com.company.file;

import java.io.*;

public class CopyFilesWithoutCamel {
    public static void main(String[] args) throws IOException{
        File inputDirectory = new File("data/input");
        File outputDirectory = new File("data/output");

        File[] files = inputDirectory.listFiles();

        for(File file : files){
            if(file.isFile()){
                File dest = new File(outputDirectory.getPath() +
                    File.separator + file.getName());
                OutputStream os = new FileOutputStream(dest);
                InputStream is = new FileInputStream(file);
                try {
                    byte[] content = new byte[(int)file.length()];
                    is.read(content);
                    os.write(content);
                }catch(IOException ioe){
                    ioe.printStackTrace();
                }finally{
                    os.close();
                    is.close();
                }
            }
        }
    }
}
