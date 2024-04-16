package tn.esprit.pi2024.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.pi2024.Entity.ImageData;
import tn.esprit.pi2024.Repository.StorageRepository;
import tn.esprit.pi2024.util.ImageUtils;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService implements IStorage{

    @Autowired
    private StorageRepository repository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }
    @Override
    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}