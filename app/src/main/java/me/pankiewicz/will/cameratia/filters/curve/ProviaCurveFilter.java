package me.pankiewicz.will.cameratia.filters.curve;

/**
 * Created by will on 5/4/2016.
 */
public class ProviaCurveFilter extends CurveFilter{
    public ProviaCurveFilter(){
        super(
                new double[] {0, 255}, // vValIn
                new double[] {0, 255}, // vValOUt
                new double[] {0, 59, 202, 255}, // rValIn
                new double[] {0, 54, 210, 255}, // rValOUt
                new double[] {0, 27, 196, 255}, // gvalIn
                new double[] {0, 21, 207, 255}, // gValOut
                new double[] {0, 35, 205, 255}, //  bValIn
                new double[] {0, 25, 277, 255}  //  bValOut
        );
    }
}
