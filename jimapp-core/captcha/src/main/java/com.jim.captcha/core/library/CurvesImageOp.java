/*
 * Copyright © 2016 JIM liu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.jim.captcha.core.library;

import com.jim.captcha.core.color.ColorFactory;
import com.jim.captcha.core.color.SingleColorFactory;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;


public class CurvesImageOp extends AbstractImageOp {

	private float strokeMin;
	private float strokeMax;
	private ColorFactory colorFactory = new SingleColorFactory();

	public float getStrokeMin() {
		return strokeMin;
	}

	public void setStrokeMin(float strokeMin) {
		this.strokeMin = strokeMin;
	}

	public float getStrokeMax() {
		return strokeMax;
	}


	public void setStrokeMax(float strokeMax) {
		this.strokeMax = strokeMax;
	}
	public ColorFactory getColorFactory() {
		return colorFactory;
	}

	public void setColorFactory(ColorFactory colorFactory) {
		this.colorFactory = colorFactory;
	}

	private double hermiteSpline(double x1, double a1, double x2, double a2, double t) {
		double t2=t*t;
	    double t3=t2*t;
	    double b=-a2-2.0*a1-3.0*x1+3.0*x2;
	    double a=a2+a1+2.0*x1-2.0*x2;
	    return a*t3+b*t2+a1*t+x1;	    
	}
	
	private double catmullRomSpline(double x0, double x1, double x2, double x3, double t) {
		double a1 = (x2 - x0) / 2;
		double a2 = (x3 - x1) / 2;
		return hermiteSpline(x1, a1, x2, a2, t);
	}

	@Override
	public BufferedImage filter(BufferedImage src, BufferedImage dest) {
		if (dest == null) {
			dest = createCompatibleDestImage(src, null);
		}
		double width = dest.getWidth();
		double height = dest.getHeight();
		Graphics2D g2 = (Graphics2D) src.getGraphics();
		g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		Random r = new Random();
		int cp = 4 + r.nextInt(3);
		int[] xPoints = new int[cp];
		int[] yPoints = new int[cp];
		width -= 10;
		for (int i = 0; i < cp; i++) {
			xPoints[i] = (int) ((int) 5 + (i * width) / (cp - 1));
			yPoints[i] = (int) (height * (r.nextDouble() * 0.5 + 0.2));
		}
		int subsections = 6;
		int[] xPointsSpline = new int[(cp - 1)*subsections];
		int[] yPointsSpline = new int[(cp - 1)*subsections];
		for (int i = 0; i < cp - 1; i++) {
			double x0 = i > 0 ? xPoints[i - 1] : 2 * xPoints[i] - xPoints[i + 1];
			double x1 = xPoints[i];
			double x2 = xPoints[i + 1];
			double x3 = (i + 2 < cp) ? xPoints[i + 2] : 2 * xPoints[i + 1] - xPoints[i];
			double y0 = i > 0 ? yPoints[i - 1] : 2 * yPoints[i] - yPoints[i + 1];
			double y1 = yPoints[i];
			double y2 = yPoints[i + 1];
			double y3 = (i + 2 < cp) ? yPoints[i + 2] : 2 * yPoints[i + 1] - yPoints[i];
			for (int j = 0; j < subsections; j++) {
				xPointsSpline[i * subsections + j] = (int) catmullRomSpline(x0, x1, x2, x3, 1.0 / subsections * j); 
				yPointsSpline[i * subsections + j] = (int) catmullRomSpline(y0, y1, y2, y3, 1.0 / subsections * j); 
			}
		}
		for (int i = 0; i < xPointsSpline.length - 1; i++) {
			g2.setColor(colorFactory.getColor(i));
			g2.setStroke(new BasicStroke(2 + 2 * r.nextFloat()));
			g2.drawLine(xPointsSpline[i], yPointsSpline[i], xPointsSpline[i + 1], yPointsSpline[i + 1]);
		}
		return src;
	}
}
