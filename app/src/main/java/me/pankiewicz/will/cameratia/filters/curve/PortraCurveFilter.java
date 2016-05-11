package me.pankiewicz.will.cameratia.filters.curve;

/**
 * Created by will on 5/4/2016.
 */
public class PortraCurveFilter extends CurveFilter {
    public PortraCurveFilter(){
        super(
                new double[] { 0, 23, 157, 255 }, // vValIn
                new double[] { 0, 20, 173, 255 }, // vValOut
                new double[] { 0, 69, 213, 255 }, // rValIn
                new double[] { 0, 69, 218, 255 }, // rValOut
                new double[] { 0, 52, 189, 255 }, // gValIn
                new double[] { 0, 47, 196, 255 }, // gValOut
                new double[] { 0, 41, 231, 255 }, // bValIn
                new double[] { 0, 46, 228, 255 }); // bValOut
    }
}
