package util;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

public class ImageUploader {
    public static String uploadImage(Part filePart) throws IOException {
        // Definir o caminho onde a imagem será salva
        String uploadDir = "/path/img";

        // Obter o nome do arquivo original
        String fileName = filePart.getSubmittedFileName();

        // Criar o caminho completo para o arquivo
        String filePath = uploadDir + File.separator + fileName;
        File uploadedFile = new File(filePath);

        // Salvar a imagem no servidor
        filePart.write(filePath);
        
        return filePath;
    }
}