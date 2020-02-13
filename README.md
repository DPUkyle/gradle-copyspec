copyspec behavior
==============================================

This dummy project takes an existing tar, `inner.tar`, and bundles it in a new tar, `outer.tar`.

Unfortunately the project was already configured to create reproducible builds, 
and the executable bit of `bin/run.sh` will be lost as a consequence

1. Run `$ ./gradlew outer`; the task outputs the tar metadata
2. Notice `-rw-r--r--  0 0      0          36 Jan  1  1970 bin/run.sh` or similar

This is not desirable as the executable bit has been lost.

CopySpec#setFileMode docs suggest that:

> Sets the Unix permissions to use for the target files. 
> null means that existing permissions are preserved. 
> It is dependent on the copy action implementation whether 
> these permissions will actually be applied.

... but I may not be configuring the task correctly.