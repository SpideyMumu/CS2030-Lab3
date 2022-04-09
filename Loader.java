class Loader {
    private final int identifier;
    private final Cruise cruise;

    Loader(int identifier, Cruise cruise) {
        this.identifier = identifier;
        this.cruise = cruise;
    }

    int getIdentifier() {
        return this.identifier;
    }

    boolean canServe(Cruise newCruise) {
        return newCruise.getArrivalTime() >= this.getNextAvailableTime();
    }

    Loader serve(Cruise newCruise) {
        if (this.canServe(newCruise)) {
            return new Loader(identifier, newCruise);
        } else {
            return this;
        }
    }

    int getNextAvailableTime() {
        return cruise.getServiceCompletionTime(); 
    }
    
    @Override
    public String toString() {
        return "Loader " + this.identifier + " serving " + this.cruise.toString();
    }
}


