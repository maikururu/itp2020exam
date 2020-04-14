import Exercise.Exercise;

import javax.script.AbstractScriptEngine;
import java.util.List;

public class Main {

    List<Program> programs;

    public static void main(String[] args) {
        Exercise e1 = new Exercise("Løp for faen", 10, 60, 2, 3);
        System.out.println(e1.toString());

        Program newProgram = new Program();
        System.out.println(newProgram.toString());
        System.out.println("New change");
    }

    public void addPrograms(Program _program)
    {
        programs.add(_program);
    }

}