package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {
    
    public static void main(String[] args) {
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path));
//            }
//        };
        
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);
        
//        Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");
        Path directory = FileSystems.getDefault().getPath("FileTree"+ File.separator + "Dir2");
        
        try (DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)) {
            for (Path file : contents) {
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e) {
            System.out.println(e.getMessage());
        }
        
        String separator = File.separator;
        System.out.println(separator);
        
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);
        
        try {
            Path tempFile = Files.createTempFile("myApp", ".appext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());
            Files.deleteIfExists(tempFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for (FileStore store : stores) {
            System.out.println("Volume name/Drive letter = " + store);
            System.out.println("file store = " + store.name());
        }
    
        System.out.println("*****************************************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for (Path path : rootPaths) {
            System.out.println(path);
        }
    
        System.out.println("---------Walking Tree for Dir2----------");
        
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try {
            Files.walkFileTree(dir2Path, new PrintNames());
            
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    
        System.out.println("\n---------Copy Dir2 to Dir4/Dir2Copy----------");
        Path copyPath =
                FileSystems.getDefault().getPath(
                        "FileTree" + File.separator + "Dir4" + File.separator + "Dir2Copy");
        
        try {
            Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        File file = new File("/Directories/files.txt");
        Path convertedPath = file.toPath();
        System.out.println("ConvertedPath = " + convertedPath);
        
        File parent = new File("/Directories");
        File resolvedFile = new File(parent, "dir/file.txt");
        System.out.println(resolvedFile.toPath());
        
        resolvedFile = new File("/Directories", "dir/file.txt");
        System.out.println(resolvedFile.toPath());
        
        Path parentPath = Paths.get("/Directories");
        Path childRelativePath = Paths.get("dir.file.txt");
        System.out.println(parentPath.resolve(childRelativePath));
        
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("Working directory = " + workingDirectory.getAbsolutePath());
    
        System.out.println("---------Print Dir2 Content using list()----------");
        File dir2File = new File(workingDirectory, "/FileTree/Dir2");
        String[] dir2Content = dir2File.list();
        for (int i = 0; i < dir2Content.length; i++) {
            System.out.println("i = " + i + ": " + dir2Content[i]);
        }
    
        System.out.println("---------Print Dir2 Content using listFiles()----------");
        File[] dir2Files = dir2File.listFiles();
        for (int i = 0; i < dir2Files.length; i++) {
            System.out.println("i = " + i + ": " + dir2Files[i].getName());
        }
    }
}