To start the game, run the Compile&Run.bat (on Windows) or the Compile&Run.sh (on Linux) files.

The launch script file contains the following lines:

javac -d out src/*java  //Compiles source .java codes
javadoc -d doc src/*   //Creates javadoc
java -cp out src.Main   //Runs the relevant Main class to launch game

If for some reason the .bat or .sh files dont work, these three command lines can be used to launch the game manually from the root of the game folder.