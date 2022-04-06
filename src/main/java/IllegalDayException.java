public class IllegalDayException extends RuntimeException {

    public IllegalDayException(int day){
        super("Некорректно указан день " + day);
    }
}
