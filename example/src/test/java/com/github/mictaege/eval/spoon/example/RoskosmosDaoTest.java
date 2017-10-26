package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Fork;
import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.BearerType.SOJUS;
import static com.github.mictaege.eval.spoon.example.BearerType.WOSTOK;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

@OnlyIf(ROSKOSMOS)
public class RoskosmosDaoTest {

    @Test
    public void shouldProvideRoskosmosBearers() {
        assertThat(dao().findBearers(), hasItems(WOSTOK, SOJUS));
    }

    @Fork(ifActive = ROSKOSMOS, to = "roskosmosDao")
    private DaoIF dao() {
        return new RoskosmosDao();
    }

    private DaoIF roskosmosDao() {
        return new Dao();
    }

}