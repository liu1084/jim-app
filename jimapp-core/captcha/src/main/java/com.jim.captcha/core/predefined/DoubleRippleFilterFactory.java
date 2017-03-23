/*
 * Copyright © 2016 JIM liu
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.jim.captcha.core.predefined;

import com.jim.captcha.core.filter.AbstractFilterFactory;
import com.jim.captcha.core.library.DoubleRippleImageOp;

import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;


public class DoubleRippleFilterFactory extends AbstractFilterFactory {

	protected List<BufferedImageOp> filters;
	protected DoubleRippleImageOp ripple;
	
	public DoubleRippleFilterFactory() {
		ripple = new DoubleRippleImageOp();
	}

	@Override
	public List<BufferedImageOp> getFilters() {
		if (filters == null) {
			filters = new ArrayList<BufferedImageOp>();
			filters.add(ripple);
		}
		return filters;
	}
	
}
