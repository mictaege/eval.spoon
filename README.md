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
- ``` gradle variantEsa``` for selecting _ESA_
- ``` gradle variantNasa``` for selecting _NASA_
- ``` gradle variantRoskosmos``` for selecting _ROSKOSMOS_

and then type ```gradle clean run``` or ```gradle clean build```
