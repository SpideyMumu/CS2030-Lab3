class RecycledLoader extends Loader {
    private static final int MAINTAINENCE = 60;

    RecycledLoader(int identifier, Cruise cruise) {
        super(identifier, cruise);
    }

    int getNextAvailableTime() {
        return super.getNextAvailableTime() + MAINTAINENCE;
    }
    
    Loader serve(Cruise newCruise) {
        if (this.canServe(newCruise)) {
            return new RecycledLoader(super.getIdentifier(), newCruise);
        } else {
            return this;
        }
    }

    @Override
    public String toString() {
        return "Recycled " + super.toString();
    }
}
