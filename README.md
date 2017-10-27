# eval.spoon
> This repository contains an evaluation of the Java analysis and transformation framework [Spoon](http://spoon.gforge.inria.fr/index.html).


# Usage

First clone the repository into a local directory, e.g with the name _eval.spoon_.

This will result in the following structure:

```
eval.spoon
│
├───example
│   ├───....
└───processing
    ├───...
```

## Gradle

_eval.spoon_ contains two gradle builds _example_ and _processing_ whereas _example_ includes _processing_ as a composite build.

_example_ contains an example application that demonstrates how _Spoon_ processing could be used to realize different flavors of an application. In this simple case the flavors are different types of space agencies: ESA, NASA and ROSKOSMOS.

To run or build the application with gradle the flavor has to be selected before the _run_ or _build_ task.

Go to the _example_ directory (```cd example```)
and type
- ``` gradle variantEsa run``` for _ESA_
- ``` gradle variantNasa run``` for _NASA_
- ``` gradle variantRoskosmos run``` for _ROSKOSMOS_

## IntelliJ

The usage with _IntelliJ_ is a little bit tricky.

### Create a new project

First create a new project: ```File/New/Project From Existing Sources.../``` and select the ```eval.spoon/example``` folder. _IntelliJ_ should then recognize the gradle composite build and the resulting project should have two modules both for _example_ and _processing_.

![Create Project](https://github.com/mictaege/eval.spoon/tree/master/doc/ProjectFromExistingSources.png)

The resulting Project should look like this:

![Project](https://github.com/mictaege/eval.spoon/tree/master/doc/Project.png)

Now comes the crucial part:

The _Spoon_ processing is done by gradle and the processed classes will end up in ```./build/classes/...``` but _IntelliJ`s_ build system compiles the sources to ```./out/...``` independently from gradle by default.  So you have to instruct _IntelliJ_ to delegate the build to gradle:

![Delegate Build to Gradle](https://github.com/mictaege/eval.spoon/tree/master/doc/DelegateBuildToGradle.png)

The next important thing is that the compiler output path must point to ```./build/classes/...``` and not to ```./out/...```. This is already defined in ```eval.spoon/example/build.gradle``` but you should check it in the _Project Structure_:

![Project Structure](https://github.com/mictaege/eval.spoon/tree/master/doc/ProjectStructure.png)

If all this settings are done you can configure a _Run Configuration_ for the examples main class _TowerControlApp_. As in gradle you have to select the flavor before the build happens:

![Project Structure](https://github.com/mictaege/eval.spoon/tree/master/doc/RunConfiguration.png.png)
