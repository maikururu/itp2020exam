import java.util.List;

public class Main {

    List<Program> programs;

    public static void main(String[] args) {
        Program newProgram = new Program();
        System.out.println(newProgram.toString());
        System.out.println("New change");
    }

    public void addPrograms(Program _program) {
        programs.add(_program);
    }
}
