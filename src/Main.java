import java.util.List;

public class Main {

    List<Program> programs;

    public static void main(String[] args) {
        Program newProgram = new Program();
        System.out.println(newProgram.toString());
    }

    public void addPrograms(Program _program) {
        programs.add(_program);
    }
}
