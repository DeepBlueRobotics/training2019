class yourname {
    public static double previousPos;
    public static double sumOfPositions;
    public static final double timeStep = 0.0001;

    public static void main(String[] args) {
        System.out.println(test());
    }
    /*
     * returns goal velocity to motors 
     */
    public static double simPID(double kP, double kI, double kD, double position, double goal) {
        if (position - previousPos > 0.01) {
            position = 0.01;
        }
        double error = (goal - position) / goal;
        System.out.println("Error: " + error);
        sumOfPositions += position * timeStep;
        System.out.println("Sum: " + sumOfPositions);
        System.out.println("(" + position + " - " + previousPos + ") / " + timeStep);
        double speed = (position - previousPos) / timeStep;
        if (speed > 20) {
            speed = 20;
        }
        System.out.println("Speed: " + speed);
        previousPos = position;
        System.out.println((kP * error) + " + " + (kI * sumOfPositions) + " + " + (kD * speed));
        double value = (kP * error) + (kI * sumOfPositions) + (kD * speed);
        System.out.println("Return value: " + value);
        if (value < 1) {
            return value;
        } else {
            return 1;
        }
    }

    public static boolean test() {
        sumOfPositions = 0;
        previousPos = 0;
        double goalVelocity = simPID(1, 1, 1, 1, 2);
        return (goalVelocity == 1);
    }
}