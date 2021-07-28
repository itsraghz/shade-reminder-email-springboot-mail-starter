package com.example.emailapp.entity;

import com.example.emailapp.repository.AppealRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class AppealRepositoryTest {

    @Autowired
    private AppealRepository appealRepository;

    List<Appeal> appealList = new ArrayList<>();

    @Test
    public void testAllAppeals() {
        appealList = appealRepository.findAll();

        assertNotNull(appealList);

        System.out.println("Total Appeals : " + appealList.size());

        /*appealList.stream()
                .forEach(a -> {
                    System.out.println("Appeal Id : " + a.getId() + ", Name : " + a.getName());
                });*/

        appealList.stream().forEach(System.out::println);
    }


}
