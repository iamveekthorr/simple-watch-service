package com.company;

import java.io.IOException;
import java.nio.file.*;

import static java.nio.file.StandardWatchEventKinds.*;

public class WatchServiceDemo {
    private java.nio.file.WatchService watchService;
    private Path path ;

    WatchServiceDemo(){
        try{
            this.watchService = FileSystems.getDefault().newWatchService();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void registerWatchService(){
        path = Paths.get("C:\\Users\\Victor Okonkwo\\Desktop\\Demo File Creator");
        try {
            if (!Files.exists(path)) Files.createDirectory(path);

            path.register(watchService, ENTRY_DELETE, ENTRY_CREATE, ENTRY_MODIFY);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void monitor(){
        System.out.println("Monitoring.......");
        WatchKey watchKey = null;

        while(true){
            try{
                watchKey = watchService.take();

                watchKey.pollEvents().stream().map(event -> event.context().toString() + " " + event.kind()).forEach(System.out::println);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

            if(!watchKey.reset()) break;

        }
    }


}
