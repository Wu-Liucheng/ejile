package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xyz.somedefinitions.ejile.entity.Image;
import xyz.somedefinitions.ejile.util.FileUtil;

import java.util.Map;

@Controller
public class FileAction {
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    @ResponseBody
    public Image upload(@RequestParam("fileName") MultipartFile file){

        String localPath = "C://Users//25021//Pictures//upload";

        if (FileUtil.upload(file, localPath, file.getOriginalFilename())){

        }else {
        }

        return new Image(file.getOriginalFilename());
    }
}
