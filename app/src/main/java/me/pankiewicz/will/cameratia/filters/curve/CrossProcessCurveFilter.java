package me.pankiewicz.will.cameratia.filters.curve;

/**
 * Created by will on 5/4/2016.
 */
public class CrossProcessCurveFilter extends CurveFilter {
    public CrossProcessCurveFilter() {
        super(
                new double[]{0, 255}, // vValIn
                new double[]{0, 255}, // vValOut


                new double[]{0, 56, 211, 255}, // rValIn
                new double[]{0, 22, 255, 255}, // rVAlOut


                new double[]{0, 56, 208, 255}, // gvalIn
                new double[]{0, 39, 226, 255}, //gValOUt


                new double[]{0, 255}, // bValIn
                new double[]{20, 235} //bValOUt
        );
    }
}
