package com.github.mictaege.eval.spoon.example;

import static com.github.mictaege.eval.spoon.processing.Variant.NASA;

import java.util.List;

import com.github.mictaege.eval.spoon.processing.OnlyIf;

@OnlyIf(NASA)
public interface NasaProvider {

    List<NasaResult> findResults();

}
