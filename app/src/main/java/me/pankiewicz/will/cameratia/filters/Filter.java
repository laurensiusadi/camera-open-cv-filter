package me.pankiewicz.will.cameratia.filters;

import org.opencv.core.Mat;

/**
 * Created by will on 5/4/2016.
 */
public interface Filter {
    public abstract void apply(final Mat src, final Mat dst);
}
