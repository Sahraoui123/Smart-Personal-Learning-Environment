package tn.esprit.pi2024.Service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IStorage {
    public String uploadImage(MultipartFile file)throws IOException;
    public byte[] downloadImage(String fileName);
}
