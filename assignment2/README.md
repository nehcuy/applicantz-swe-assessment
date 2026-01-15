# Things to note for Assignment 2

- Both update functions have been combined into 1 for code reusability. This was due to the similarities in functionality (updating of Build Number)
- The decision to use a list of regex expressions for the `update_build_version()` function is so that multiple lines that require Build Number updates within a file might be possible
- I did not combine the relative source path `develop/global/src` into a global variable due to the fact that other files that require updating might not be under the same relative directory.
- Test folder is purely set up to test for errors caused by refactoring, ensuring original functionality is kept.
