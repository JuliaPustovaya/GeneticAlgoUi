/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.version16_10_din_ryad;

/**
 *
 * @author Юлия
 */
public class Points {
private double point;

    @Override
    public String toString() {
        return ""+point;
    }


    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

}
