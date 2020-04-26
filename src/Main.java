import Exercise.*;

import javax.script.AbstractScriptEngine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// Everyone did some work but github was not really nice to everyone.
// ^ READMe?

public class Main {


    public static void main(String[] args) {
        ExerciseManager manager = new ExerciseManager();
        manager.buildProgram();

        //Create new exercises
        System.out.println("\nCreating Exercises\n==============================================");
        Strength s1 = new Strength("Vektløfting", 8, 2, 8, 4, 40, "Dumbell");
        Balance b1 = new Balance("Yoga", 5, 2, 8, 4, "Yogamat");
        Flexibility f1 = new Flexibility("Tøying", 2, 5, 1, 3, "Har trent");
        Endurance e1 = new Endurance("Sprinting", 6, 15, 3, 1, "Løpe sko");

        //Create a new program
        System.out.println("\nAdding Exercises to Program\n==============================================");
        Program program1 = manager.programs.get(0);

        //Add exercises to program
        program1.addExercise(s1);
        program1.addExercise(b1);
        program1.addExercise(f1);
        program1.addExercise(e1);

        System.out.println(program1);

        //Create person
        System.out.println("\nCreating persons\n==============================================");
        Person person1 = new Person("Truls",7, Program.Type.Strength);
        System.out.println(person1);

        //Add person to persons list
        manager.persons.add(person1);

        //Recommend Programs to person
        System.out.println("\nRecommending Programs\n==============================================");
        List<Program> recommendProgramsList = manager.recommendPrograms(manager.programs, person1);
        person1.setCurrentProgram(recommendProgramsList.get(0));
        System.out.println(person1);

        //Check if program is appropriate to person
        System.out.println("\nChecking Appropriation\n==============================================");
        manager.isAppropriate(program1, person1);
    }
}