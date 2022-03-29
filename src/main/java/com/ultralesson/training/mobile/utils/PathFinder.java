package com.ultralesson.training.mobile.utils;

import java.util.Objects;

public class PathFinder {
    public static String findAbsPathFromRelativePath(String folder, String relativePath) {
        return Objects.requireNonNull(PathFinder.class
                        .getClassLoader()
                        .getResource(String.format("%s/%s.json",folder, relativePath)))
                .getPath();
    }
}
