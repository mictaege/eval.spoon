package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Fork;
import com.github.mictaege.eval.spoon.processing.OnlyIf;
import org.junit.Test;

import static com.github.mictaege.eval.spoon.example.BearerType.ARIANE5;
import static com.github.mictaege.eval.spoon.example.BearerType.SOJUS;
import static com.github.mictaege.eval.spoon.example.BearerType.TITAN;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BearerTest {

    @Test
    public void shouldProvideBearerType() {
        final BearerType bearerType = bearerType();

        final Bearer bearer = new Bearer(bearerType);

        assertThat(bearer.getType(), is(bearerType));
    }

    @Fork(ifActive = ESA, to = "bearerTypeEsa")
    @Fork(ifActive = NASA, to = "bearerTypeNasa")
    @Fork(ifActive = ROSKOSMOS, to = "bearerTypeRoskosmos")
    private BearerType bearerType() {
        return bearerTypeEsa();
    }

    @OnlyIf(ESA)
    private BearerType bearerTypeEsa() {
        return ARIANE5;
    }

    @OnlyIf(NASA)
    private BearerType bearerTypeNasa() {
        return TITAN;
    }

    @OnlyIf(ROSKOSMOS)
    private BearerType bearerTypeRoskosmos() {
        return SOJUS;
    }

}