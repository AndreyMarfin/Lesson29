public class IllegalStepsException extends RuntimeException{

    public IllegalStepsException(int steps){
        super("Некорректно указано количество шагов " + steps);
    }
}
