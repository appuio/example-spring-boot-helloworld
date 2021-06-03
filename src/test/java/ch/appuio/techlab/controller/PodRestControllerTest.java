package ch.appuio.techlab.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import org.junit.Test;

public class PodRestControllerTest {

    @Test
    public void getPodDescription() {
        // given
        PodRestController controller = new PodRestController();

        // when
        String podDescription = controller.pod();

        // then
        assertThat(podDescription, is("Pod: null"));
    }
}
