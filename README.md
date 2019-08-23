# DualSlalomBracketCreator
A Java program that takes in a .csv file containing qualifying time information and outputs a .csv file with seeded rider matchups based on qualification times and categories.

I would recommend either using Google Sheets or a text editor, like Notepad, to create the .csv file. Excel likes to reformat times of the format MM:SSS:mmm (where M is minute, S is second, and m is millisecond). If you choose to use Excel, just pay special attention that the times you enter remain what you mean once you leave the cell.

.csv stands for comma separated values. Open the example .csv file in a text editor like Notepad to see how the it is formatted. This might be helpful if you choose to create your own .csv file using a text editor.

If you use Excel or Google Sheets, be sure to save the file as a .csv and not as an .xslx.

# Setup
To use this program, you must have downloaded and installed the Java SDK on your computer.

I've included two resources to help with this:
  1. The Georgia Tech CS1331 installation instructions (https://cs1331.gitlab.io/install-java.html), which are also listed below
  2. Oracle’s installation instructions (https://docs.oracle.com/javase/10/)

After downloading and installing the Java SDK, download the files in this repository.

Disclaimer: I took the class CS1331 many years ago. The version of java and javac I have and used to create this program are as follows:

java -version

1.8.0_73

javac -version

javac 1.8.0_73

The Oracle installation instructions for this verison can be found here: https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

# Compiling
In the command line, navigate to the directory (using the command cd -- Google it) with the DualSlalomBracketCreator files. Once there, run the compile command:

javac DualSlalom.java

If successful, no text should be outputted. A .class file should have been generated in your directory.

# Running
After successful compilation, in the command line, make sure you are in the directory with the DualSlalomBracketCreator files. Once there, run the command below and follow the prompts.

java DualSlalom QualifyingTimes.csv

The above command is an example of how to run the program with a .csv file. If you name your .csv file differently than this example, substitute the example file name for your file name. 

In this repository, you will find a file called "QualifyingTimes.csv". Input files must be formatted according to this file in order for the program to function as expected.
This file must not contain any duplicate qualification times within the same category. If there is a tie in qualifying times within the same category, make the riders race again before running this program.

# CS1331 Installation Instructions
Installing The Java Development Kit (JDK)
Windows

    Download the Windows x64 download from Oracle here.

    NOTE: Make sure that you download the Java Development Kit (JDK) not the Java Runtime Environment (JRE). The JRE only allows you to run java programs, in order to develop your own java programs you will need the JDK.
    Run the installer that you just downloaded. Java will install in your "Program Files" folder. (You may also have a "java" folder in "Program Files (x86)" and you should ignore it because the java kit you are currently downloading will NOT install there.)
    Add the path to the bin folder in the java folder that you just installed to your PATH environment variable. Make sure that it is the path to the bin folder and not the path to a file inside the bin folder. eg: C:\Program Files\Java\jdk-10.0.2\bin
    Editing your PATH environment variable can be done by searching "environment variables" in the Windows search or by Control Panel > System and Security > System > Advanced system settings. Once you've opened the System Properties, click on "Evnironment Variables...". Find the system variable called "Path" and click on it. Click "Edit...". Add the path to the bin folder in the java folder that you just installed here. See the example above. These are separated by semi-colons if necessary by your operating system.
    Verify that you have successfully installed java by opening the command line and following the instructions below called "To confirm that your java installation was successful".

Mac OS X

    Make sure that you have installed Homebrew before proceeding! Look at the top of the resources page on this website for instructions on installing Homebrew.
    Run the folloing command in the Terminal:
    brew update
    brew tap caskroom/cask
    brew install Caskroom/cask/java

    The commands running successfully looks like this:
    Homebrew-java-install-commands.png
    Verify that you have successfully installed java.

Linux

    Most distros use the openJDK instead of Oracle's. This can lead to some issues with JavaFx, so make sure you install the Oracle version by running the following commands according to your distribution (if yours isn't listed, you probably have the expertise to install the Oracle version of Java on your own):
        Ubuntu, Debian, Mint (anything using the APT package manager):

                sudo add-apt-repository ppa:linuxuprising/java
                sudo apt update
                sudo apt install oracle-java10-installer

                # If you have other versions of java installed, run the following
                sudo update-alternatives --config java       # Select the option with Oracle java 10
                sudo update-alternatives --config javac      # Select the option with Oracle java 10

        Fedora, CentOS (anything using RPM packages):
            Install the rpm package here.
            Run the following:

                        rpm -ivh /path/to/installed/rpm  # May need sudo
                        
                        # Use the following commands to select Oracle Java 10 as the default
                        alternatives --config java
                        alternatives --config javac

    Add the JDK's bin directory to your PATH environment variable, if necessary (not required if using methods listed above).
    Verify that you have successfully installed java.

All Operating Systems
To confirm that your java installation was successful:

    At the command prompt type java -version. You should get output on the next line like java version 10.0.2.
    At the command prompt type javac -version. You should get output like javac 10.0.2.
    The output should look something like this:

    $ java --version
    java version 10.0.2
    Java(TM) SE Runtime Environment 18.3 (build 10.0.2+13)
    Java HotSpot(TM) 64-Bit Server VM (build 10.0.2+13, mixed mode)
    $ javac --version
    javac 10.0.2

    The version number should be "10.*.*" Where the * can be any number. An older version of java will not work for the purposes of this class!

Oracle's installation instructions

    Oracle, the company that makes Java, has documentation here: https://docs.oracle.com/javase/10/
