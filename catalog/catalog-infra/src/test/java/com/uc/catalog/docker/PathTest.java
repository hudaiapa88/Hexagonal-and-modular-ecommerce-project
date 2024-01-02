package com.uc.catalog.docker;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Path;

public class PathTest {
    @Test
    void pathTest(){
        File file= Path.of("../docker/docker-compose-test.yml").toFile();
        String path= file.getAbsolutePath();
        Assertions.assertThat(file.exists()).isTrue();
    }
}
