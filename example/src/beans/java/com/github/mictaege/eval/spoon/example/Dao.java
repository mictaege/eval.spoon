package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.Alter;
import com.github.mictaege.eval.spoon.processing.OnlyIf;

import java.util.List;

import static com.github.mictaege.eval.spoon.example.BearerType.ARIANE5;
import static com.github.mictaege.eval.spoon.example.BearerType.ATLAS;
import static com.github.mictaege.eval.spoon.example.BearerType.TITAN;
import static com.github.mictaege.eval.spoon.processing.Variant.ESA;
import static com.github.mictaege.eval.spoon.processing.Variant.NASA;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static java.util.Arrays.asList;

@Alter(ifActive = ESA, with = "EsaDao", nested = true)
@Alter(ifActive = NASA, with = "NasaDao", nested = true)
@Alter(ifActive = ROSKOSMOS, with = "RoskosmosDao")
public class Dao implements DaoIF {

    @Override
    public List<BearerType> findBearers() {
        throw new IllegalStateException("Not implemented.");
    }

    @OnlyIf(ESA)
    static class EsaDao implements DaoIF {
        public List<BearerType> findBearers() {
            return asList(ARIANE5);
        }
    }

    @OnlyIf(NASA)
    static class NasaDao implements DaoIF {
        public List<BearerType> findBearers() {
            return asList(ATLAS, TITAN);
        }
    }

}

