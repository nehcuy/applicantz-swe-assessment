import os
import re
from pathlib import Path
from tempfile import NamedTemporaryFile


def get_src_path_from_env() -> Path:
    """
    Get the source path from environment variable.
    Fails if the environment variable is not set.
    """
    src_path = os.environ.get("SourcePath")
    if not src_path:
        raise EnvironmentError("SourcePath environment variable is not set.")
    # Path() handles wrong/invalid path inputs
    return Path(src_path)


def get_build_num_from_env() -> int:
    """
    Get the build number from environment variable.
    Fails if the environment variable is not set.
    """
    build_num = os.environ.get("BuildNum")
    if not build_num:
        raise EnvironmentError("BuildNum environment variable is not set.")
    if not build_num.isdigit():
        raise ValueError("BuildNum must be a numeric value.")
    return int(build_num)


def update_build_version(filepath: Path, lines_to_update: list[str], build_num: int) -> None:
    """
    Perform an atomic replacement of the build number in the given
    lines of the specified file.
    
    :param filepath: Full path name to the file to be updated
    :param lines_to_update: List of regex patterns to identify lines to be updated
    :param build_num: Build number to be replaced with in the file
    """
    os.chmod(filepath, 0o755)
    with open(filepath, 'r') as fin, NamedTemporaryFile('w', delete=False) as fout:
        for line in fin:
            if any(re.search(pattern, line) for pattern in lines_to_update):
                line = re.sub(r'(\d+)', str(build_num), line)
            fout.write(line)
        fout.flush()
    os.replace(fout.name, filepath)


def main() -> None:
    sconstruct_filepath = os.path.join(get_src_path_from_env(), Path("develop/global/src/SConstruct"))
    version_filepath = os.path.join(get_src_path_from_env(), Path("develop/global/src/VERSION"))
    build_num = get_build_num_from_env()
    update_build_version(sconstruct_filepath, [r"point\=[\d]+"], build_num)
    update_build_version(version_filepath, [r"ADLMSDK_VERSION_POINT=[\d]+"], build_num)


if __name__ == "__main__":
    main()
