import Exercise.*;

import javax.script.AbstractScriptEngine;
import java.util.List;

public class Main {

    List<Program> programs;

    public static void main(String[] args) {

        Strength s1 = new Strength("Vektløfting", 8, 2, 8, 4, 40, "Dumbell");
        Balance b1 = new Balance("Yoga", 5, 2, 8, 4, "Yogamat");
        Flexibility f1 = new Flexibility("Tøying", 2, 5, 1, 3, "Har trent");
        Endurance e1 = new Endurance("Sprinting", 10, 15, 3, 1, "Løpe sko");

        Program program1 = new Program(40);
        program1.addExercise(s1);
        program1.addExercise(b1);
        program1.addExercise(f1);
        program1.addExercise(e1);

        System.out.println(program1.toString());
        System.out.println("New change");
    }

    public void addPrograms(Program _program)
    {
        programs.add(_program);
    }

}