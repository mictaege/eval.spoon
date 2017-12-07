package com.github.mictaege.eval.spoon.example;

import com.github.mictaege.eval.spoon.processing.OnlyIf;

import java.util.List;

import static com.github.mictaege.eval.spoon.example.BearerType.SOJUS;
import static com.github.mictaege.eval.spoon.example.BearerType.WOSTOK;
import static com.github.mictaege.eval.spoon.processing.Variant.ROSKOSMOS;
import static java.util.Arrays.asList;

@OnlyIf(ROSKOSMOS)
class RoskosmosDao implements DaoIF {

    private List<BearerType> list = asList(WOSTOK, SOJUS);

    public List<BearerType> findBearers() {
        return list;
    }
}
