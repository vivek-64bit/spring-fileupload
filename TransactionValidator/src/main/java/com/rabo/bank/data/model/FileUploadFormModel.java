package com.rabo.bank.data.model;

import javax.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadFormModel {

    private MultipartFile file;

    @NotNull
    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
