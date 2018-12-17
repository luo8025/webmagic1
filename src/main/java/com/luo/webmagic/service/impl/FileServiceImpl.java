package com.luo.webmagic.service.impl;

import com.luo.webmagic.service.FileService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public void downloadPicture(List<String> list) {
        URL url = null;
        for (String url1:list) {
            try {
                String path="D:/Test1"+"/"+Math.random()+".jpg";
                url = new URL(url1);
                DataInputStream dataInputStream = new DataInputStream(url.openStream());
                FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
                ByteArrayOutputStream output = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = dataInputStream.read(buffer)) > 0) {
                    output.write(buffer, 0, length);
                }
                fileOutputStream.write(output.toByteArray());
                dataInputStream.close();
                fileOutputStream.close();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
