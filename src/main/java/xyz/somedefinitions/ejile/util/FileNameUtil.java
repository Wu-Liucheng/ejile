package xyz.somedefinitions.ejile.util;

public class FileNameUtil {

    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getFileName(String fileOriginName){
        return UUIDUtil.getUUID() + FileNameUtil.getSuffix(fileOriginName);
    }
}
