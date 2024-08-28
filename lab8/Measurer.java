package labs.lab8;

public interface Measurer<T> {
	/**
	* Computes the measure of an object.
	*
	* @param anObject the object to be measured
	* @return the measure
	*/
	double measure(T anObject);	
	
	static <T> T max(T[] values, Measurer<T> meas) {
		if (values == null || values.length == 0) {
			return null;
		}
		
		T maxObj = values[0];
		double maxMeas = meas.measure(maxObj);
		
		for (int i = 1; i < values.length; i++) {
			T curr = values[i];
			double currMeas = meas.measure(curr);
			
			if (currMeas > maxMeas) {
				maxObj = curr;
				maxMeas = currMeas;
			}
		}
		
		return maxObj;
	}
}
