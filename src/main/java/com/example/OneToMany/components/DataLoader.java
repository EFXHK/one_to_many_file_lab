package com.example.OneToMany.components;

import com.example.OneToMany.models.File;
import com.example.OneToMany.models.Folder;
import com.example.OneToMany.models.User;
import com.example.OneToMany.repository.FileRepository;
import com.example.OneToMany.repository.FolderRepository;
import com.example.OneToMany.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FileRepository fileRepository;

    @Autowired
    FolderRepository folderRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {

        User bane = new User("Agent Smith");
        userRepository.save(bane);

        User morpheus = new User("Morpheus");
        userRepository.save(morpheus);


        Folder catPics = new Folder("Kitty cats", bane);
        folderRepository.save(catPics);

        Folder sunglassesCatalogue = new Folder("Sunglasses collection", morpheus);
        folderRepository.save(sunglassesCatalogue);


        File notavirus = new File("cat pic", "exe", "12PB", catPics);
        fileRepository.save(notavirus);

        File sunglasses = new File("Pince-nez style, tinted", "jpeg", "3.8MB", sunglassesCatalogue);
        fileRepository.save(sunglasses);

    }
}
