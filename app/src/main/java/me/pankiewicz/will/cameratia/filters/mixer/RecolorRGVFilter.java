package me.pankiewicz.will.cameratia.filters.mixer;

import org.opencv.core.Core;
import org.opencv.core.Mat;

import java.lang.reflect.Array;
import java.util.ArrayList;

import me.pankiewicz.will.cameratia.filters.Filter;

/**
 * Created by will on 5/4/2016.
 */
public final class RecolorRGVFilter implements Filter {

    private final ArrayList<Mat> mChannels = new ArrayList<Mat>(4);

    @Override
    public void apply(final Mat src, final Mat dst) {
        Core.split(src, mChannels);

        final Mat r = mChannels.get(0);
        final Mat g = mChannels.get(1);
        final Mat b = mChannels.get(2);

        // dst.b = min(dst.r, dst.g, dst.b)
        Core.min(b, r, b);
        Core.min(b, g, b);

        Core.merge(mChannels, dst);
    }
}
