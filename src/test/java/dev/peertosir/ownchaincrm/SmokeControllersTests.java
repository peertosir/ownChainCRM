package dev.peertosir.ownchaincrm;

import dev.peertosir.ownchaincrm.controller.DetailController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeControllersTests {

    private final DetailController detailController;

    @Autowired
    public SmokeControllersTests(DetailController detailController) {
        this.detailController = detailController;
    }

    @Test
    public void detailControllerLoads() {
        assertThat(detailController).isNotNull();
    }
}
