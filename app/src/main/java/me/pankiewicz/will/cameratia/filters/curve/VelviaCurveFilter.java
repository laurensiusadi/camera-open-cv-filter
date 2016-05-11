package me.pankiewicz.will.cameratia.filters.curve;

/**
 * Created by will on 5/4/2016.
 */
public class VelviaCurveFilter extends CurveFilter{
    public VelviaCurveFilter(){
        super(
                new double[] { 0, 128, 221, 255}, // vValIn
                new double[] {0, 118, 215, 255}, // vValOut
                new double[] {0, 25, 122, 165, 255}, // rValIn
                new double[] { 0, 21, 153, 206, 255}, // rValOUt
                new double[] { 0, 25, 95, 181, 255}, //  gvalIn
                new double[] { 0, 21, 102, 208, 255}, // gvalOut
                new double[] { 0, 35, 205, 255}, // bValIn
                new double[] {0, 25, 227, 255} // bValOut
        );
    }
}
