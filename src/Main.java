import Exercise.*;

import javax.script.AbstractScriptEngine;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Program> programs = new ArrayList<Program>();
        List<Person> persons = new ArrayList<Person>();

        System.out.println("\nCreating Exercises\n==============================================");
        //Create new exercises
        Strength s1 = new Strength("Vektløfting", 8, 2, 8, 4, 40, "Dumbell");
        Balance b1 = new Balance("Yoga", 5, 2, 8, 4, "Yogamat");
        Flexibility f1 = new Flexibility("Tøying", 2, 5, 1, 3, "Har trent");
        Endurance e1 = new Endurance("Sprinting", 6, 15, 3, 1, "Løpe sko");

        System.out.println("\nCreating Programs\n==============================================");
        //Create a new program
        Program program1 = new Program(Program.Type.Strength);

        //Add exercises to program
        program1.addExercise(s1);
        program1.addExercise(b1);
        program1.addExercise(f1);
        program1.addExercise(e1);

        //Add program to programs list
        programs.add(program1);

        System.out.println("\nCreating persons\n==============================================");

        //Create person
        Person person1 = new Person("Truls",7, Program.Type.Strength);

        //Add person to persons list
        persons.add(person1);

        System.out.println("\nRecommending Programs\n==============================================");

        //Recommend Programs to person
        recommendPrograms(programs, person1);


        System.out.println("\nChecking Appropriation\n==============================================");

        //Check if program is appropriate to person
        isAppropriate(program1, person1);
    }

    // Method to check if persons preferred exercise exists or not, disregarding acceptable intensity level
    public static void recommendPrograms(List<Program> _programs, Person _person){
        // loops through programs
        for (Program program : _programs){
            if(_person.acceptableProgram(program)){
                System.out.println("\nProgram "+program.getProgramType()+" is recommended for "+ _person.getName());
            }
        }
    }

    // Method to tell if a program is appropriate for a given person.
    public static void isAppropriate(Program _program, Person _person){
        if(_person.acceptableProgram(_program)) {
            System.out.println("\nProgram "+_program.getProgramType()+" is appropriate for "+ _person.getName());
        }
    }
}