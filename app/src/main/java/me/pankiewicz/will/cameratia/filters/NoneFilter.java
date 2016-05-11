package me.pankiewicz.will.cameratia.filters;

import org.opencv.core.Mat;

/**
 * Created by will on 5/4/2016.
 */
public class NoneFilter  implements Filter{
    @Override
    public void apply(final Mat src, final Mat dst){
        // do nothing....
    }
}
