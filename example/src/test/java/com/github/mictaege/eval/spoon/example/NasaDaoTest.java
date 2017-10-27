package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Fork;
import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.BearerType.ATLAS;
import static com.github.mictaege.eval.spoon.example.BearerType.TITAN;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

@OnlyIf(NASA)
public class NasaDaoTest {

    @Test
    public void shouldProvideNasaBearers() {
        assertThat(dao().findBearers(), hasItems(ATLAS, TITAN));
    }

    @Fork(ifActive = NASA, to = "nasaDao")
    private DaoIF dao() {
        return new Dao.NasaDao();
    }

    private DaoIF nasaDao() {
        return new Dao();
    }

}