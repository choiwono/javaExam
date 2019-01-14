package my.examples;

public class FileManager {
    public static Folder scan(String folderDir) {
        java.io.File file = new java.io.File(folderDir);
        if(!file.exists()){
            throw new RuntimeException("폴더가 없어요.");
        }
        if(!file.isDirectory()){
            throw new RuntimeException("폴더가 아닙니다.");
        }

        Folder folder = new Folder(file.getParentFile().getAbsolutePath(), file.getName());
        scanFolder(folder, file);

        return folder;
    }

    public static void scanFolder(Folder folder, java.io.File file) {
        java.io.File[] files = file.listFiles();
        for(java.io.File f: files) {
            if(f.isFile()) {
                File childFile = new File(file.getAbsolutePath(),f.getName());
                childFile.setSize(f.length());
                folder.add(childFile);
            } else {
                Folder childFolder = new Folder(file.getAbsolutePath(), f.getName());
                folder.add(childFolder);
                scanFolder(childFolder, f);
            }
        }
    }
}
