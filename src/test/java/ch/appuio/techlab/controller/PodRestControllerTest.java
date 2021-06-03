package ch.appuio.techlab.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class PodRestControllerTest {

    @Test
    public void getPodDescription() {
        // when
        PodRestController controller = new PodRestController();
        String podDescription = controller.pod();

        // then
        assertThat(podDescription, is("Pod: null"));
    }
}
