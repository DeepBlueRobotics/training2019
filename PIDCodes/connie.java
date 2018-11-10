class connie {
        
        static double cSum = 0;
        static double previousPosition;
        static double timeStep = 0.0001; 
        static final double max = 1;
        static final double min = -1;

    public static double simPID(double kP, double kD, double kI, double position, double total) {
        double firstTerm = kP * ((total - position) / total);
        cSum += previousPosition * timeStep;
        double secondTerm = kI * cSum;
        double lastTerm = kD * (position - previousPosition) / timeStep;
        previousPosition = position;
        System.out.println("First term " + firstTerm);
        System.out.println("Second term " + secondTerm);
        System.out.println("Last term " + lastTerm);
        double PID = firstTerm + secondTerm + lastTerm;
        if (PID > max)
        {
            PID = max;
        }
        else if (PID < min)
        {
            PID = min;
        }
        return PID;
    }

    public static boolean test() {
        double velocity = simPID(1, 1, 1, 4, 3);
        System.out.println("Actual velocity: " + velocity);
        return (velocity == 1);
    }
    
    public static void main(String[] args) {
        System.out.println(test());
    }

}