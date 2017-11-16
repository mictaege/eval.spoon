package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Fork;
import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.BearerType.ARIANE5;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

@OnlyIf(ESA)
public class EsaDaoTest {

    @Test
    public void shouldProvideEsaBearers() {
        assertThat(dao().findBearers(), hasItems(ARIANE5));
    }

    @Fork(ifActive = ESA, to = "esaDao")
    private DaoIF dao() {
        return new Dao.EsaDao();
    }

    private DaoIF esaDao() {
        return new Dao();
    }

}