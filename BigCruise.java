class BigCruise extends Cruise {
    private final int length;
    private final int numOfPassengers;
    private static final int loaderLength = 40;
    private static final int servedPassengersPerMin = 50; 

    BigCruise(String identifier, int arrivalTime, int length, int numOfPassengers) {
        super(identifier, arrivalTime, getNumOfLoader(length), 
                getServiceTime(numOfPassengers));        
        this.length = length;
        this.numOfPassengers = numOfPassengers;

    }

    private static int getNumOfLoader(int length) { 
        return length / loaderLength + (length % loaderLength == 0 ? 0 : 1);
    }

    private static int getServiceTime(int numOfPassengers) {
        return numOfPassengers / servedPassengersPerMin + 
            (numOfPassengers % servedPassengersPerMin == 0 ? 0 : 1);
    }
    
    //@Override
    //public String toString() {
    //    return null;
    //}
}
