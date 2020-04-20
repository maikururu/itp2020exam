import Exercise.*;

import javax.script.AbstractScriptEngine;
import java.util.List;

// Everyone did some work but github was not really nice to everyone.
// ^ READMe?

public class Main {

    List<Program> programs;

    public static void main(String[] args) {

        Strength s1 = new Strength("Vektløfting", 8, 2, 8, 4, 40, "Dumbell");
        Balance b1 = new Balance("Yoga", 5, 2, 8, 4, "Yogamat");
        Flexibility f1 = new Flexibility("Tøying", 2, 5, 1, 3, "Har trent");
        Endurance e1 = new Endurance("Sprinting", 6, 15, 3, 1, "Løpe sko");

        Program program1 = new Program("Flexibility");
        program1.addExercise(s1);
        program1.addExercise(b1);
        program1.addExercise(f1);
        program1.addExercise(e1);

        System.out.println(program1.toString());
        System.out.println("New change");

        Person person1 = new Person(7, "Strength");
        person1.addNewProgram(program1);
        System.out.println(person1);

    }

    public void addPrograms(Program _program)
    {
        programs.add(_program);
    }

}