import Exercise.*;

import javax.script.AbstractScriptEngine;
import java.util.List;

public class Main {

    List<Program> programs;

    public static void main(String[] args) {
        //Exercise e1 = new Exercise("Løp for faen", 10, 60, 2, 3);
        //System.out.println(e1.toString());

        Strength s1 = new Strength("Vektløfting", 5, 2, 8, 4, 40, "Dumbell");
        System.out.println(s1.toString());

        Balance b1 = new Balance("Yoga", 5, 2, 8, 4, "Yogamat");
        System.out.println(b1.toString());

        Program program1 = new Program(40, 10);
        program1.addExercise(s1);
        program1.addExercise(b1);

        System.out.println(program1.toString());
        System.out.println("New change");
    }

    public void addPrograms(Program _program)
    {
        programs.add(_program);
    }

}