import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ExerciseManager {
    List<Program> programs = new ArrayList<Program>();
    List<Person> persons = new ArrayList<Person>();

    public ExerciseManager(){

    }

    //Method to build a new program
    public void buildProgram() throws IOException {
        System.out.println("Welcome to Prøvekaninen personal training software." +
                "\n To create a new program, choose your desired Program Type, by entering its numerical value." +
                "\n Balance: 1" +
                "\n Endurance: 2" +
                "\n Flexibility: 3" +
                "\n Strength: 4" +
                "\n At any moment, enter 'exit' or 'q' to quit.");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String strIn = "";

        while(!strIn.equals("q") || strIn.equals("exit")) {
            strIn = reader.readLine();

            Program newProgram = null;

            switch (strIn) {
                case "1": {
                    newProgram = new Program(Program.Type.Balance);
                    break;
                }
                case "2": {
                    newProgram = new Program(Program.Type.Endurance);
                    break;
                }
                case "3": {
                    newProgram = new Program(Program.Type.Flexibility);
                    break;
                }
                case "4": {
                    newProgram = new Program(Program.Type.Strength);
                    break;
                }
            }

            if(newProgram!= null) {
                programs.add(newProgram);
                System.out.println("Created program "+ newProgram.getProgramType() +", and added it to the list of programs.");
                strIn = "q";
            } else  {
                System.out.println("Could not create program, invalid value entered.");
            }
        }
    }

    // Method to check if persons preferred exercise exists or not, disregarding acceptable intensity level
    public List<Program> recommendPrograms(List<Program> _programs, Person _person){
        List<Program> programList = new ArrayList<Program>();

        // loops through programs
        for (Program program : _programs){
            if(_person.acceptableProgram(program)){
                System.out.println("\nProgram "+program.getProgramType()+" is recommended for "+ _person.getName());
                programList.add(program);
            }
        }
        return programList;
    }

    // Method to tell if a program is appropriate for a given person.
    public boolean isAppropriate(Program _program, Person _person){
        if(_person.acceptableProgram(_program)) {
            System.out.println("\nProgram "+_program.getProgramType()+" is appropriate for "+ _person.getName());
            return true;
        }
        return false;
    }
}
